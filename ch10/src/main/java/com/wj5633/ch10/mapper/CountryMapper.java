package com.wj5633.ch10.mapper;

import com.wj5633.ch10.model.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created at 2019/7/10 18:23.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Mapper
public interface CountryMapper {

    List<Country> selectAll();

}
