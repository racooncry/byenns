package com.racoon.yxw.bye996.lamda.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author yangxw
 * @Date 2019/12/17 8:51
 * @Description
 * @Version 1.0
 */
public class FilerServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();

        // 通过lamda打印文件内容
        fileService.fileHandle("D:\\yangxw\\work\\my_project\\byenns\\src\\test\\java\\com\\racoon\\yxw\\bye996\\lamda\\file\\FilerServiceTest.java",fileContent -> {
            // 注释
            System.out.println(fileContent);
        });
    }
}
