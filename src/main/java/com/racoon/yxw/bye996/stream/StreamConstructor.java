package com.racoon.yxw.bye996.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author yangxw
 * @Date 2019/12/23 9:18
 * @Description 流的四种构建形式
 * @Version 1.0
 */
public class StreamConstructor {

    /**
     * 由数值构建流
     */
    @Test
    public void streamFromValue() {
        Stream stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }


    /**
     * 由数组构建流
     */
    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }


    /**
     * 由文件构建流
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("D:\\yangxw\\work\\my_project\\byenns\\src\\main\\java\\com\\racoon\\yxw\\bye996\\stream\\StreamConstructor.java"));

        stream.forEach(System.out::println);
    }

    /**
     * 由函数构建流,无限流
     */
    @Test
    public void streamFromFunction() {
       // Stream<Integer> stream = Stream.iterate(0, n -> n + 2);

        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);
    }



}
