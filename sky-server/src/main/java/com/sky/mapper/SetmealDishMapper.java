package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MrLu
 * @version 1.0
 * @description: TODO
 * @date 2024/10/3 0:08
 */

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据 id列表查询
     * @param ids 列表
     * @return 集合
     */

    public List<SetmealDish> getById(List<Long> ids);
}
