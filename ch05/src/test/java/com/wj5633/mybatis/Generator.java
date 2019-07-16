package com.wj5633.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created at 2019/7/9 1:52.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class Generator {

    public static void main(String[] args) throws IOException, XMLParserException,
            InvalidConfigurationException, SQLException, InterruptedException {

        List<String> warnings = new ArrayList<>();

        boolean overwrite = true;

        InputStream is = Generator.class.getResourceAsStream("/generator/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        warnings.forEach(System.out::println);
    }
}
