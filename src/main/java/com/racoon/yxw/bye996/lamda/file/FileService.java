package com.racoon.yxw.bye996.lamda.file;

import java.io.*;

/**
 * @Author yangxw
 * @Date 2019/12/17 8:46
 * @Description
 * @Version 1.0
 */
public class FileService {

    public void fileHandle(String url, FileConsumer fileConsumer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(url)
                )
        );
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        // 调用函数式编程接口，实现业务逻辑
        fileConsumer.fileHandler(stringBuilder.toString());
    }
}
