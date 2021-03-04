package com.soul.service;

import com.soul.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> list();
    Goods find(Integer goodsId);
    int insert(Goods goods);
    int update(Goods goods);
}
