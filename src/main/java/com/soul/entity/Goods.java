package com.soul.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private Double price;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date produceDate;
    private String picture;
    private Category category;
}
