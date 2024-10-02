package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

/**
 * @author MrLu
 * @version 1.0
 * @description: TODO
 * @date 2024/10/2 18:16
 */
public interface DishService {
    /**
     *  添加菜品和口味
     * @param dishDTO 菜品模型
     */
    void insertDishAndFlavors(DishDTO dishDTO);

    /**
     *  分页查询
     * @param dishDTO 查询条件
     * @return 分页模型
     */
    PageResult search(DishPageQueryDTO dishDTO);
}
