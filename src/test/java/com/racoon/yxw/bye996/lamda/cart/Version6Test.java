package com.racoon.yxw.bye996.lamda.cart;

import com.alibaba.fastjson.JSON;
import com.racoon.yxw.bye996.lambda.cart.CartService;
import com.racoon.yxw.bye996.lambda.cart.Sku;
import com.racoon.yxw.bye996.lambda.cart.SkuPredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author yangxw
 * @Date 2019/12/16 9:00
 * @Description
 * @Version 1.0
 */
public class Version6Test {
    @Test
    public void filterSkusByCategoryOrTotalPrice() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        // 查找购物车中数码类商品
        List<Sku> result = CartService.filterSkus(cartSkuList, (Sku sku) -> sku.getTotalPrice() > 1000);

        System.out.println(JSON.toJSONString(result, true));
    }

}
