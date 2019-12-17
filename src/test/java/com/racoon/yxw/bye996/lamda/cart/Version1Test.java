package com.racoon.yxw.bye996.lamda.cart;

import com.alibaba.fastjson.JSON;
import com.racoon.yxw.bye996.lambda.cart.CartService;
import com.racoon.yxw.bye996.lambda.cart.Sku;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author yangxw
 * @Date 2019/12/16 9:00
 * @Description
 * @Version 1.0
 */
public class Version1Test {
    @Test
    public void filterElectronicesSkus(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        // 查找购物车中数码类商品
         List<Sku> result = CartService.filterElectronicesSkus(cartSkuList);
        // 格式出输出
        System.out.println(JSON.toJSONString(result,true));
    }

}
