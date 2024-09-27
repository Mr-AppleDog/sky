package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cxy784853792
 * @version 1.0
 * @description: TODO 套餐表
 * @date 2024/9/26 17:41
 */
@Mapper
public interface SetmealMapper {
    @Select("select count(*) from sky_take_out.setmeal where category_id=#{id}")
    Integer countByCategoryId(Long id);
}
