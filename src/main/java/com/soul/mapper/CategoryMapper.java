package com.soul.mapper;

import com.soul.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    //查询所有方法
    List<Category> findAll();
    //根据编号查询数据
    Category find(Integer categoryId);
    //添加商品分类数据
    int add(Category category);
    //修改商品分类信息
    int update(Category category);
}
