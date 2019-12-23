package com.racoon.yxw.bye996.lamda.stream;

import com.racoon.yxw.bye996.lamda.file.FileService;
import com.racoon.yxw.bye996.stream.StreamVs;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author yangxw
 * @Date 2019/12/23 8:22
 * @Description
 * @Version 1.0
 */
public class StreamVsTest {
    @Test
    public void oldHandle() throws IOException {
        StreamVs streamVs =new StreamVs();
        streamVs.oldCartHandle();
    }


    @Test
    public void newHandle() throws IOException {
        StreamVs streamVs =new StreamVs();
        streamVs.newCartHandle();
    }
}
