package com.soul.serviceImpl;

import com.soul.entity.Goods;
import com.soul.mapper.GoodsMapper;
import com.soul.service.GoodsService;

import javax.annotation.Resource;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> list() {
        return goodsMapper.findAll();
    }

    @Override
    public Goods find(Integer goodsId) {
        return goodsMapper.find(goodsId);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.add(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }
}
