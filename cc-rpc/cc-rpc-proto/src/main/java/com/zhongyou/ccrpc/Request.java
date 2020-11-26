package com.zhongyou.ccrpc;

import lombok.Data;

/**
 * 表示RPC的一个请求
 * @author ccx
 * @date 2020/6/9 17:50
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] paramters;
}
