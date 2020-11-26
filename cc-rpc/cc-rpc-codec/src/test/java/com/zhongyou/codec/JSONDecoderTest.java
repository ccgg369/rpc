package com.zhongyou.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ccx
 * @date 2020/6/10 17:11
 */
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("峰哥");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);

        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes,TestBean.class);
        assertEquals(bean.getName(),bean2.getName());
        assertEquals(bean.getAge(),bean2.getAge());
    }
}