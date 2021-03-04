package com.soul.mapper;

import com.soul.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    List<Goods> findAll();

    Goods find(Integer goodsId);

    int add(Goods goods);

    int update(Goods goods);
}
