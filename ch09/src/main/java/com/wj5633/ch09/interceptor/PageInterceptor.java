package com.wj5633.ch09.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created at 2019/7/10 16:47.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Intercepts(
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
@SuppressWarnings({"unchecked", "rawtypes"})
public class PageInterceptor implements Interceptor {

    public static final List<ResultMapping> EMPTY_RESULTMAPPING
            = new ArrayList<>();
    private Dialect dialect;
    private Field additionalParametersField;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameterObject = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        if (!dialect.skip(ms.getId(), parameterObject, rowBounds)) {
            ResultHandler resultHandler = (ResultHandler) args[3];
            Executor executor = (Executor) invocation.getTarget();
            BoundSql boundSql = ms.getBoundSql(parameterObject);

            // 反射获取动态参数
            Map<String, Object> additionalParameters = (Map<String, Object>) additionalParametersField.get(boundSql);

            if (dialect.beforeCount(ms.getId(), parameterObject, rowBounds)) {
                MappedStatement countMs = newMappedStatement(ms, Long.class);

                CacheKey countKey = executor.createCacheKey(
                        countMs, parameterObject, RowBounds.DEFAULT, boundSql
                );
                String countSql = dialect.getCountSql(
                        boundSql, parameterObject, rowBounds, countKey
                );
                BoundSql countBoundSql = new BoundSql(
                        ms.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject
                );

                for (String key : additionalParameters.keySet()) {
                    countBoundSql.setAdditionalParameter(key, additionalParameters.get(key));
                }
                Object countResultList = executor.query(
                        countMs, parameterObject, RowBounds.DEFAULT, resultHandler, countKey, countBoundSql
                );
                Long count = (Long) ((List) countResultList).get(0);
                dialect.afterCount(count, boundSql, rowBounds);
                if (count == 0L) {
                    return dialect.afterPage(new ArrayList(), parameterObject, rowBounds);
                }
            }
            // 判断是否需要分页查询
            if (dialect.beforePage(ms.getId(), parameterObject, rowBounds)) {
                CacheKey pageKey = executor.createCacheKey(
                        ms, parameterObject, rowBounds, boundSql
                );
                String pageSql = dialect.getPageSql(
                        boundSql, parameterObject, rowBounds, pageKey
                );
                BoundSql pageBoundSql = new BoundSql(
                        ms.getConfiguration(), pageSql, boundSql.getParameterMappings(), parameterObject
                );
                for (String key : additionalParameters.keySet()) {
                    pageBoundSql.setAdditionalParameter(key, additionalParameters.get(key));
                }

                List resultList = executor.query(
                        ms, parameterObject, RowBounds.DEFAULT, resultHandler, pageKey, pageBoundSql
                );
                return dialect.afterPage(resultList, parameterObject, rowBounds);
            }
            return invocation.proceed();

        }

        return null;
    }

    private MappedStatement newMappedStatement(MappedStatement ms, Class<?> resultType) {
        MappedStatement.Builder builder = new MappedStatement.Builder(
                ms.getConfiguration(),
                ms.getId() + "_Count",
                ms.getSqlSource(),
                ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());

        List<ResultMap> resultMaps = new ArrayList<>();
        ResultMap resultMap = new ResultMap.Builder(
                ms.getConfiguration(),
                ms.getId(),
                resultType,
                EMPTY_RESULTMAPPING).build();
        resultMaps.add(resultMap);
        builder.resultMaps(resultMaps);
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialectClass = properties.getProperty("dialect");

        try {
            dialect = (Dialect) Class.forName(dialectClass).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("使用 PageInterceptor 分页插件，必须设置 dialect 属性");
        }
        dialect.setProperties(properties);

        try {
            additionalParametersField = BoundSql.class.getDeclaredField("additionalParameters");
            additionalParametersField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
