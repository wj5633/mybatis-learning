package com.wj5633.ch09.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

/**
 * Created at 2019/7/10 17:29.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class MySqlDialect implements Dialect {
    @Override
    public boolean skip(String msId, Object parameterObject, RowBounds rowBounds) {
        return rowBounds == RowBounds.DEFAULT;
    }

    @Override
    public boolean beforeCount(String msId, Object parameterObject, RowBounds rowBounds) {
        return rowBounds instanceof PageRowBounds;
    }

    @Override
    public String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey) {
        return "select count(*) from (" + boundSql.getSql() + ") temp";
    }

    @Override
    public void afterCount(long count, Object parameterObject, RowBounds rowBounds) {
        if (rowBounds instanceof PageRowBounds) {
            ((PageRowBounds) rowBounds).setTotal(count);
        }
    }

    @Override
    public boolean beforePage(String msId, Object parameterObject, RowBounds rowBounds) {
        return rowBounds != RowBounds.DEFAULT;
    }

    @Override
    public String getPageSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey pageKey) {
        pageKey.update("RowBounds");
        return boundSql.getSql() + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
    }

    @Override
    public Object afterPage(List pageList, Object parameterObject, RowBounds rowBounds) {
        return pageList;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
