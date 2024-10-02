package com.sky.service;

import com.sky.dto.DishDTO;

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
}
