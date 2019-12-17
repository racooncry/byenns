package com.racoon.yxw.bye996.lambda.cart;

/**
 * @Author yangxw
 * @Date 2019/12/16 8:39
 * @Description 商品类型枚举
 * @Version 1.0
 */
public enum SkuCategoryEnum {
    CLOTHING(10,"服装类"),
    ELECTRONICES(20,"数码类"),
    SPORTS(30,"运动类"),
    BOOKS(40,"图书类");

    // 商品类型编号
    private Integer code;
    // 商品类型的名称
    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
