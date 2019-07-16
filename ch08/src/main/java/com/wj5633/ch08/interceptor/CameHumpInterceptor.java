package com.wj5633.ch08.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.*;

/**
 * Created at 2019/7/10 16:19.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Intercepts(
        @Signature(
                type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}))
@SuppressWarnings({"unchecked", "rawtypes"})
public class CameHumpInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> list = (List<Object>) invocation.proceed();

        for (Object o : list) {
            if (o instanceof Map) {
                processMap((Map<String, Object>) o);
            } else {
                break;
            }
        }
        return list;
    }

    /**
     * 处理 Map 类型
     * @param map 一条查询记录
     */
    private void processMap(Map<String, Object> map) {
        Set<String> keySet = new HashSet<>(map.keySet());
        for (String key : keySet) {
            if (key.charAt(0)>='A'
            && key.charAt(0)<='z'
                    || key.indexOf('_')>=0) {
                Object value = map.get(key);
                map.remove(key);
                map.put(underlineToCamelhump(key), value);
            }
        }
    }

    /**
     *  下划线转为驼峰式
     * @param key 带下划线
     * @return 驼峰式
     */
    private String underlineToCamelhump(String key) {
        StringBuffer sb = new StringBuffer();
        boolean nextUpperCase = false;
        for (int i = 0; i < key.length(); i++) {
            char c= key.charAt(i);
            if (c=='_'){
                if (sb.length()>0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase){
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase=false;
                }else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
