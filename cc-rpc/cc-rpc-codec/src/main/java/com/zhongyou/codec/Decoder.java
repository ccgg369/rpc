package com.zhongyou.codec;

/**
 * 反序列化
 *
 * @author ccx
 * @date 2020/6/10 16:23
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
