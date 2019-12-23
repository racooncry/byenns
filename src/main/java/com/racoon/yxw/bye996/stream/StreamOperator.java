package com.racoon.yxw.bye996.stream;

import com.alibaba.fastjson.JSON;
import com.racoon.yxw.bye996.lambda.cart.CartService;
import com.racoon.yxw.bye996.lambda.cart.Sku;
import com.racoon.yxw.bye996.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.OpenOption;
import java.util.*;

/**
 * @Author yangxw
 * @Date 2019/12/23 8:41
 * @Description 演示流的各种操作
 * @Version 1.0
 */
public class StreamOperator {

    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    @Test
    public void filterTest() {
        list.stream().filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }


    /**
     * map:将一个元素转换为另一个元素
     */
    @Test
    public void mapTest() {
        list.stream().map(sku -> sku.getSkuName())
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }


    /**
     * flatMap使用：将一个对象转换称流
     */
    @Test
    public void flatMapTest() {
        list.stream().flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * peek: 对流中元素进行遍历操作,与forEach类似，但不会销毁元素
     */
    @Test
    public void peek() {
        list.stream().peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * sorted: 对流元素进行排序，有状态操作
     */
    @Test
    public void sortTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }


    /**
     * distinct: 对流元素进行去重，有状态操作
     */
    @Test
    public void distinctTest() {
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * skip: 跳过前N条记录，有状态操作
     */
    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * limit: 截断前N条记录，有状态操作
     */
    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * 分页
     */
    @Test
    public void limitSkipPageTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(0 * 3)
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }


    /**
     * allMatch: 终端操作，短路操作, 所有元素满足返回true
     */
    @Test
    public void allMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }


    /**
     * anyMatchTest: 终端操作，短路操作,  匹配到元素即返回true
     */
    @Test
    public void anyMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    /**
     * noneMatch: 终端操作，短路操作,  没用元素符合要求 返回true
     */
    @Test
    public void noneMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10000);
        System.out.println(match);
    }

    /**
     * 找到第一个
     */
    @Test
    public void findFirstTest() {
        Optional<Sku> optionalSku = list.stream()
                .findFirst();

        System.out.println(JSON.toJSONString(optionalSku.get(),true));
    }


    /**
     * 找到任意一个  有就返回， 并行上速度比findFirst快
     */
    @Test
    public void findAnyTest() {
        Optional<Sku> optionalSku = list.stream()
                .findAny();

        System.out.println(JSON.toJSONString(optionalSku.get(),true));
    }


    /**
     * max 使用：取最大
     */
    @Test
    public void maxTest() {
        OptionalDouble optionalDouble = list.stream()
                // 将一个类型映射为Double类型的元素
                .mapToDouble(Sku::getTotalPrice)
                .max();

        System.out.println(optionalDouble.getAsDouble());
    }

    /**
     * min 使用：取最小
     */
    @Test
    public void minTest() {
        OptionalDouble optionalDouble = list.stream()
                // 将一个类型映射为Double类型的元素
                .mapToDouble(Sku::getTotalPrice)
                .min();

        System.out.println(optionalDouble.getAsDouble());
    }


    /**
     * count 使用：取元素个数
     */
    @Test
    public void countTest() {
        long count = list.stream()
                .count();

        System.out.println(count);
    }



}
