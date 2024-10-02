package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishMapper;
import com.sky.mapper.FlavorMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MrLu
 * @version 1.0
 * @description: TODO
 * @date 2024/10/2 18:16
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private FlavorMapper flavorMapper;


    /**
     *  添加菜品和口味
     * @param dishDTO 菜品模型
     */
    @Override
    public void insertDishAndFlavors(DishDTO dishDTO) {

        Dish dish=new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        //添加一天菜品数据
        dishMapper.insert(dish);
        Long id = dish.getId();
        //添加n条口味
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(flavors!=null&&flavors.size()>0){
            for (DishFlavor df: flavors) {
                df.setDishId(id);
            }
            flavorMapper.insertBatch(flavors);
        }

    }

    /**
     * 分页查询
     * @param dishDTO 查询条件
     * @return 分页模型
     */
    @Override
    public PageResult search(DishPageQueryDTO dishPageQueryDTO) {
        //用PageHelper 分页查询
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        //执行
        Page<Dish> page=dishMapper.pageSearch(dishPageQueryDTO);

        //获取结果和条数
        long total = page.getTotal();
        List<Dish> result = page.getResult();

        return new PageResult(total,result);
    }
}
