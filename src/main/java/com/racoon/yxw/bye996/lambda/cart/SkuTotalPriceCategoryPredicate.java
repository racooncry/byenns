package com.racoon.yxw.bye996.lambda.cart;

/**
 * @Author yangxw
 * @Date 2019/12/16 9:20
 * @Description 对sku的商品总价是否超出2000作为判断标准
 * @Version 1.0
 */
public class SkuTotalPriceCategoryPredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() >= 2000;
    }
}
