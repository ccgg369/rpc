package com.zhongyou.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ccx
 * @date 2020/6/10 16:47
 */
public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("峰哥");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }
}