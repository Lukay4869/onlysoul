package com.soul.service;

import com.soul.entity.Category;

import java.util.List;

public interface CategoryService {
    //查询所有分类
    List<Category> list();
    //按编号查询分类
    Category find(Integer categoryId);
    //插入数据
    int insert(Category category);
    //修改数据
    int update(Category category);
}
