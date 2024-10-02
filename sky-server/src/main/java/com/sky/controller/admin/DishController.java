package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MrLu
 * @version 1.0
 * @description: 菜品相关接口
 * @date 2024/10/2 18:12
 */
@RestController
@RequestMapping("/admin/dish")
@ApiOperation("菜品相关操作")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 添加菜品
     * @param dishDTO 菜品模型
     * @return 成功
     */
    @PostMapping
    @ApiOperation("添加菜品")
    public Result save(@RequestBody DishDTO dishDTO){
        dishService.insertDishAndFlavors(dishDTO);
        return Result.success();
    }
}
