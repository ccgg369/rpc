package com.zhongyou.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json序列化实现
 *
 * @author ccx
 * @date 2020/6/10 16:27
 */
public class JSONEncoder implements Encoder{

    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
