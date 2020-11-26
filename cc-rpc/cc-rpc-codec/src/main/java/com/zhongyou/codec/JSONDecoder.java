package com.zhongyou.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author ccx
 * @date 2020/6/10 16:45
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
