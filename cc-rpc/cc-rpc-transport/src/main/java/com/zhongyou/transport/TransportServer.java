package com.zhongyou.transport;

/**
 * 1、启动、监听
 * 2、接收请求
 * 3、关闭监听
 * @author ccx
 * @date 2020/6/11 13:03
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
