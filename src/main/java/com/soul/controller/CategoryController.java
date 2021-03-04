package com.soul.controller;

import com.soul.entity.Category;
import com.soul.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class CategoryController {
    //定义业务层对象
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        return "category_list";
    }

    @RequestMapping("/addShow")
    public String addShow(){
        return "category_add";
    }

    @RequestMapping("/addSubmit")
    public String addSubmit(Category category){
        //插入数据
        categoryService.insert(category);
        return "redirect:/admin/list";
    }
    @RequestMapping("/updateShow")
    public String updateShow(Integer categoryId,Model model){
        //根据编号查询数据
        Category category = categoryService.find(categoryId);
        model.addAttribute("category",category);
        return "category_update";
    }
    @RequestMapping("/updateSubmit")
    public String updateSubmit(Category category){
        categoryService.update(category);
        return "redirect:/admin/list";
    }
}
