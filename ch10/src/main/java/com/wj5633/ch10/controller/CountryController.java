package com.wj5633.ch10.controller;

import com.wj5633.ch10.mapper.CountryMapper;
import com.wj5633.ch10.model.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created at 2019/7/10 18:44.
 *
 * @author wangjie
 * @version 1.0.0
 */

@RestController
public class CountryController {

    private final CountryMapper countryMapper;

    public CountryController(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @RequestMapping("/country")
    public List<Country> listCountry() {
        return countryMapper.selectAll();
    }

}
