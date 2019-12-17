package com.racoon.yxw.bye996.lamda.file;

/**
 * @Author yangxw
 * @Date 2019/12/17 8:47
 * @Description
 * @Version 1.0
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * 函数式接口抽象方法
     * @param fileContent -- 文件字符串
     */
    void fileHandler(String fileContent);
}
