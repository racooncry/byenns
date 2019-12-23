package com.racoon.yxw.bye996.stream;

import com.alibaba.fastjson.JSON;
import com.racoon.yxw.bye996.lambda.cart.CartService;
import com.racoon.yxw.bye996.lambda.cart.Sku;
import com.racoon.yxw.bye996.lambda.cart.SkuCategoryEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Author yangxw
 * @Date 2019/12/23 8:12
 * @Description 原始集合操作与Stream集合操作
 * @Version 1.0
 */
public class StreamVs {


    /**
     * 1 想看看购物车中都有什么商品
     * 2 图书类商品都买
     * 3 其余的商品中买两件最贵的
     * 4 只需要两件商品的名称和总价
     */

    public void oldCartHandle() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        /**
         * 1 打印所有商品
         */
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        List<Sku> notBooksSkuList = new ArrayList<>();
        /**
         * 图书类过滤
         */
        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
                notBooksSkuList.add(sku);
            }
        }

        /**
         * 排序
         */
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if (sku1.getTotalPrice() > sku2.getTotalPrice()) {
                    return -1;
                } else if (sku1.getTotalPrice() < sku2.getTotalPrice()) {
                    return 1;
                }
                return 0;
            }
        });

        List<Sku> top2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            top2.add(notBooksSkuList.get(i));
        }

        /**
         * 求总价
         */
        Double money = 0.0;
        for (Sku sku : top2) {
            money += sku.getTotalPrice();
        }

        /**
         * 获取两件商品的名称
         */
        List<String> resultSkuyNameList = new ArrayList<>();
        for (Sku sku : top2) {
            resultSkuyNameList.add(sku.getSkuName());
        }

        /**
         * 打印输出结果
         */
        System.out.println(JSON.toJSONString(resultSkuyNameList, true));
        System.out.println("商品总价：" + money);
    }


    /**
     * 以Stream流方式实现需求
     */
    public void newCartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));

        List<String> resultSkuyNameList = CartService.getCartSkuList().stream()
                /**
                 * 1 打印商品信息
                 */
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                /**
                 * 2 过滤掉图书商品
                 */
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                /**
                 * 3 排序商品总价
                 */
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                /**
                 * 4 商品总价
                 */
                .limit(2)
                /**
                 * 5 累加商品总金额
                 */
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                /**
                 * 6 获取商品名称
                 */
                .map(sku -> sku.getSkuName())
                /**
                 * 7 收集结果
                 */
                .collect(Collectors.toList());

        /**
         * 打印输出结果
         */
        System.out.println(JSON.toJSONString(resultSkuyNameList, true));
        System.out.println("商品总价：" + money.get());
    }
}
