package com.wj5633.mybatis;

import com.wj5633.ch01.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created at 2019/7/8 14:15.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            List<Country> countryList = sqlSession.selectList("selectAll");
            printCountryList(countryList);
        }

    }

    private void printCountryList(List<Country> countries) {
        countries.forEach(country -> System.out.println(country.toString()));
    }
}
