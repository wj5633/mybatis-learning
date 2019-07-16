package com.wj5633.ch10;

import com.wj5633.ch02.mapper.UserMapper;
import com.wj5633.ch02.model.SysUser;
import com.wj5633.ch10.mapper.CountryMapper;
import com.wj5633.ch10.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Created at 2019/7/9 2:05.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Slf4j
@SpringBootApplication
@MapperScan(value = {"com.wj5633.ch10.mapper", "com.wj5633.ch02.mapper"},
        nameGenerator = MapperNameGenerator.class)
public class Ch10Application implements CommandLineRunner {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(Ch10Application.class, args);
    }

    @Override
    public void run(String... args) {
        List<Country> countryList = countryMapper.selectAll();
        countryList.forEach(System.out::println);
        List<SysUser> sysUserList = userMapper.selectAll();
        sysUserList.forEach(System.out::println);
    }
}
