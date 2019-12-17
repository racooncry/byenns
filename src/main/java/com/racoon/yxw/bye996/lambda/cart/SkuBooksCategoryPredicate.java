package com.racoon.yxw.bye996.lambda.cart;

/**
 * @Author yangxw
 * @Date 2019/12/16 9:20
 * @Description 对sku的商品类型为图书类的判断标准
 * @Version 1.0
 */
public class SkuBooksCategoryPredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
