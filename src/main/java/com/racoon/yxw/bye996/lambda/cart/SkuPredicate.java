package com.racoon.yxw.bye996.lambda.cart;

/**
 * @Author yangxw
 * @Date 2019/12/16 9:16
 * @Description Sku选择谓词接口
 * @Version 1.0
 */
public interface SkuPredicate {
    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);
}
