package com.zhongyou.ccrpc;

import lombok.Data;

/**
 * 表示RPC返回
 * @author ccx
 * @date 2020/6/9 17:52
 */
@Data
public class Response {
    /**
     * 服务返回编码，0-成功，非0失败
     */
    private int code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     * 返回数据
     */
    private Object data;
}
