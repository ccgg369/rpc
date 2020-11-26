package com.zhongyou.example;

import com.zhongyou.server.RpcServer;

/**
 * @author ccx
 * @date 2020/6/15 16:44
 */
public class Server {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(ClacServcie.class, new ClacServcieImpl());
        rpcServer.start();
    }
}
