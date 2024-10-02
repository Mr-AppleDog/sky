package com.sky.mapper;

import com.sky.entity.DishFlavor;
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
}
