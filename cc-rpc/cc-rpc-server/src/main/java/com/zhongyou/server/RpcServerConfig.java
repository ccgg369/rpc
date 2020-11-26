package com.zhongyou.server;

import com.zhongyou.codec.Decoder;
import com.zhongyou.codec.Encoder;
import com.zhongyou.codec.JSONDecoder;
import com.zhongyou.codec.JSONEncoder;
import com.zhongyou.transport.HttpTransportServer;
import com.zhongyou.transport.TransportServer;
import lombok.Data;

/**
 * server配置
 *
 * @author ccx
 * @date 2020/6/14 14:20
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
