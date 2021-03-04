package com.soul.serviceImpl;

import com.soul.entity.Category;
import com.soul.mapper.CategoryMapper;
import com.soul.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    //定义mapper对象，完成数据库的访问操作
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        return categoryMapper.findAll();
    }

    @Override
    public Category find(Integer categoryId) {
        return categoryMapper.find(categoryId);
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }
}
