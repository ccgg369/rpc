package com.zhongyou.ccrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 网络传输的一个端点
 * @author ccx
 * @date 2020/6/9 17:47
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
