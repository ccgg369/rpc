package com.zhongyou.codec;

/**
 * 序列化
 *
 * @author ccx
 * @date 2020/6/10 16:23
 */
public interface Encoder {
    byte[] encode(Object obj);
}
