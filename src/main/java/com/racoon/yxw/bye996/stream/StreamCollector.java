package com.racoon.yxw.bye996.stream;

import com.alibaba.fastjson.JSON;
import com.racoon.yxw.bye996.lambda.cart.CartService;
import com.racoon.yxw.bye996.lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author yangxw
 * @Date 2019/12/23 9:27
 * @Description 预定义收集器使用
 * @Version 1.0
 */
public class StreamCollector {

    /**
     * 转集合
     */
    @Test
    public void toList() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> collect = cartSkuList.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect, true));
    }

    /**
     * 分组
     */
    @Test
    public void group() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        // Map<分组条件，结果集合>
        Map<Object, List<Sku>> group = cartSkuList.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        System.out.println(JSON.toJSONString(group, true));
    }

    /**
     * 分区只是分组的一个特例
     */
    @Test
    public void partition(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        Map<Boolean, List<Sku>> collect = cartSkuList.stream().collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));
        System.out.println(JSON.toJSONString(collect, true));
    }
}
