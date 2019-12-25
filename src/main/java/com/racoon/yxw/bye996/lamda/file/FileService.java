package com.racoon.yxw.bye996.lamda.file;

import org.junit.Test;

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


    @Test
    public void oldFileHandleClose(String url, FileConsumer fileConsumer) {
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;


        try {
            fileInputStream = new FileInputStream(url);
            inputStreamReader = new InputStreamReader(
                    fileInputStream
            );
            bufferedReader = new BufferedReader(
                    inputStreamReader
            );
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            // 调用函数式编程接口，实现业务逻辑
            fileConsumer.fileHandler(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void newFileHandleClose(String url, FileConsumer fileConsumer) {
        try (
                FileInputStream fileInputStream = new FileInputStream(url);
                InputStreamReader inputStreamReader = new InputStreamReader(
                        fileInputStream
                );
                BufferedReader bufferedReader = new BufferedReader(
                        inputStreamReader
                );
        ) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            // 调用函数式编程接口，实现业务逻辑
            fileConsumer.fileHandler(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
