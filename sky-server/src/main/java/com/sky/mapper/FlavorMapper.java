package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MrLu
 * @version 1.0
 * @description: 口味操作
 * @date 2024/10/2 18:22
 */
@Mapper
public interface FlavorMapper {
    /**
     * 批量插入口味
     * @param flavors 口味
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 删除菜品的口味
     * @param id 菜品id
     */
    @Delete("delete from sky_take_out.dish_flavor where dish_id=#{id}")
    void deleteByid(Long id);


    /**
     * 根据菜品id 查询口味
     * @param id
     * @return
     */
    List<DishFlavor> getByDishId(Long id);
}
