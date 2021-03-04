package com.soul.controller;

import com.soul.entity.Category;
import com.soul.entity.Goods;
import com.soul.service.CategoryService;
import com.soul.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin")
@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/goodsList")
    public String list(Model model){
        List<Goods> goodsList = goodsService.list();
        model.addAttribute("goodsList",goodsList);

        return "goods_list";
    }
    @RequestMapping("/goodsAddShow")
    public String addShow(Model model){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        return "goods_add";

    }

    @RequestMapping("/goodsAddSubmit")
    public String addSubmit(Goods goods, MultipartFile file){
        String imgFile=null;
        //判断是否上传了图片
        if (file.isEmpty()){
            //如果没有上传图片，则使用默认图片
            imgFile="/img/kenan.jpg";
        }else {
            //生成新的文件名
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            //使用新的文件名构建新的对象
            File f = new File("d:/proj_img", newFile);
            //判断上级目录是否存在，不存在则创建
            if (!f.getParentFile().exists()){
                f.mkdirs();
            }
            try {
                //将上传的文件存储到指定的磁盘位置
                file.transferTo(f);
                //记录上传文件的web访问路径
                imgFile="/upfile/"+newFile;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //设置goods对象的图片路径
        goods.setPicture(imgFile);
        //保存goods对象到数据库
        goodsService.insert(goods);
        //跳转到商品查询页面
        return "redirect:/goodsList";
    }

    @RequestMapping("/updateShow2")
    public String updateShow(Integer goodsId,Model model){
        //根据商品编号获取商品信息
        Goods goods = goodsService.find(goodsId);
        //查询分类数据
        List<Category> categoryList = categoryService.list();
        model.addAttribute("goods",goods);
        model.addAttribute("categoryList",categoryList);
        return "/goods_update";
    }
    @RequestMapping("/goodsUpdateSubmit")
    public String updateSubmit(Goods goods, MultipartFile file){
        //判断是否上传了图片
        if (!file.isEmpty()){
            //生成新的文件名
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            //使用新的文件名构建新的对象
            File f = new File("d:/proj_img", newFile);
            //判断上级目录是否存在，不存在则创建
            if (!f.getParentFile().exists()){
                f.mkdirs();
            }
            try {
                //将上传的文件存储到指定的磁盘位置
                file.transferTo(f);
                goods.setPicture("/upfile/"+newFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //保存goods对象到数据库
        goodsService.update(goods);
        //跳转到商品查询页面
        return "redirect:/goodsList";
    }
}
