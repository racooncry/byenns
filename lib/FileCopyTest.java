package com.racoon.yxw.bye996.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author yangxw
 * @Date 2019/12/25 8:58
 * @Description JDK7之前的文件拷贝
 * @Version 1.0
 */
public class FileCopyTest {



    public void copyFile(){
        /**
         * 1. 创建输入/输出流
         * 2. 执行文件拷贝，读取文件内容，写入到另一个文件中
         * 3. 关闭文件流资源
         */

        // 定义输入路径和输出路径
        String originaUrl="D:\\yangxw\\work\\my_project\\byenns\\lib\\FileCopyTest.java";
        String targetUrl = "D:\\yangxw\\work\\my_project\\byenns\\lib\\targetTest\\target.txt";

        FileInputStream originalFileInputStream=null;
        FileOutputStream targetFileOutStream=null;

        try {
            originalFileInputStream = new FileInputStream(originaUrl);
            targetFileOutStream = new FileOutputStream(targetUrl);

            // 读取的字节信息
            int content;

            // 迭代，读取/写入字节
            while ((content=originalFileInputStream.read())!=-1){
                targetFileOutStream.write(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(targetFileOutStream!=null){
                try {
                    targetFileOutStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(originalFileInputStream!=null){
                try {
                    originalFileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
