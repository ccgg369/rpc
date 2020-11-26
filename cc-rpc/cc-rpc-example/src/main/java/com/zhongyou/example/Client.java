package com.zhongyou.example;

import com.zhongyou.client.RpcClient;

/**
 * @author ccx
 * @date 2020/6/15 16:44
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        ClacServcie clacServcie = client.getProxy(ClacServcie.class);

        int r1 = clacServcie.add(1,2);
        int r2 = clacServcie.minus(10,1);
        System.out.println(r1 + " " +  r2);
    }
}
