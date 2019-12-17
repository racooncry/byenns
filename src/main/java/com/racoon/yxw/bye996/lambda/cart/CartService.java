package com.racoon.yxw.bye996.lambda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangxw
 * @Date 2019/12/16 8:38
 * @Description
 * @Version 1.0
 */
public class CartService {
    // 提前构造数据
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "无人机", 4999.00, 1, 4999.0, SkuCategoryEnum.ELECTRONICES));
            add(new Sku(4032, "VR-一体机", 4999.00, 1, 4999.0, SkuCategoryEnum.ELECTRONICES));

            add(new Sku(65402, "纯色衬衫", 2299.0, 1, 4999.0, SkuCategoryEnum.CLOTHING));
            add(new Sku(65032, "牛仔裤", 123.0, 1, 4999.0, SkuCategoryEnum.CLOTHING));

            add(new Sku(65432, "跑步机", 499.00, 1, 4999.0, SkuCategoryEnum.SPORTS));

            add(new Sku(154032, "JAVA编程思想", 4999.00, 1, 4999.0, SkuCategoryEnum.BOOKS));
            add(new Sku(6532, "算法", 4999.00, 1, 4999.0, SkuCategoryEnum.BOOKS));
            add(new Sku(354032, "进阶指南", 4999.00, 1, 4999.0, SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取商品信息
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * Version 1.0.0
     * 找出购物车中所有电子产品
     *
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicesSkus(List<Sku> cartSkuList) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (SkuCategoryEnum.ELECTRONICES.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }


    /**
     * Version 2.0.0
     * 根据传入商品类型参数，找出购物车中同种商品类型的商品列表
     *
     * @param cartSkuList
     * @param categoryEnum
     * @return
     */
    public static List<Sku> filterSkusByCategory(List<Sku> cartSkuList, SkuCategoryEnum categoryEnum) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (categoryEnum.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }


    /**
     * 根据传入的商品类型或者商品总价进行判断
     *
     * @param cartSkuList
     * @param categoryEnum
     * @param totalPrice
     * @param categortOrPrice
     * @return
     */
    public static List<Sku> filterSkusByCategoryOrTotalPrice(List<Sku> cartSkuList, SkuCategoryEnum categoryEnum, Double totalPrice, Boolean categortOrPrice) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (categoryEnum.equals(sku.getSkuCategory())) {
                // 根据商品类型判断，sku类型与输入类型比较
                // 根据商品总价来判断，sku总价与输入总价比较
                if (
                        (categortOrPrice && categoryEnum.equals(sku.getSkuCategory())) ||
                                (!categortOrPrice && sku.getTotalPrice() > totalPrice)
                ) {
                    result.add(sku);
                }
            }
        }
        return result;
    }

    public static List<Sku> filterSkus(List<Sku> cartSkuList, SkuPredicate skuPredicate) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            // 根据不同的sku判断策略
            if (skuPredicate.test(sku)) {
                result.add(sku);
            }
        }
        return result;
    }
}
