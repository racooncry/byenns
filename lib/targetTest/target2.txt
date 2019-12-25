package com.racoon.yxw.bye996.resources;

import org.junit.Test;

import java.io.*;

/**
 * @Author yangxw
 * @Date 2019/12/25 9:05
 * @Description 基于jdk1.8 实现正确关闭流资源方法
 * @Version 1.0
 */
public class NewFileCopyTest {


    @Test
    public void copyFile() {
        // 定义输入路径和输出路径
        String originaUrl = "D:\\yangxw\\work\\my_project\\byenns\\lib\\NewFileCopyTest.java";
        String targetUrl = "D:\\yangxw\\work\\my_project\\byenns\\lib\\targetTest\\target2.txt";


        try (
                FileInputStream originalFileInputStream = new FileInputStream(originaUrl);
                FileOutputStream targetFileOutPutStream = new FileOutputStream(targetUrl);
        ) {
            int content;
            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutPutStream.write(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
