package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cxy784853792
 * @version 1.0
 * @description: TODO 菜品表
 * @date 2024/9/26 17:41
 */
@Mapper
public interface DishMapper {
    /**
     * 根据分类id统计所属分类的数量
     * @param id 分类id
     * @return 所属数量
     */
    @Select("select count(*) from sky_take_out.dish where category_id=#{id}")
    Integer countByCategoryId(Long id);
}
