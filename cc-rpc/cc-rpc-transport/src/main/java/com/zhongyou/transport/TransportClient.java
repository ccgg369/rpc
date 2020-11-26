package com.zhongyou.transport;

import com.zhongyou.ccrpc.Peer;

import java.io.InputStream;

/**
 * 1、创建连接
 * 2、发送数据,并且等待响应
 * 3、关闭连接
 * @author ccx
 * @date 2020/6/11 13:00
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();

}
