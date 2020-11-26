package com.zhongyou.client;

import com.zhongyou.ccrpc.Peer;
import com.zhongyou.codec.Decoder;
import com.zhongyou.codec.Encoder;
import com.zhongyou.codec.JSONDecoder;
import com.zhongyou.codec.JSONEncoder;
import com.zhongyou.transport.HttpTransportClient;
import com.zhongyou.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author ccx
 * @date 2020/6/15 15:39
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RadndomTransportSelector.class;
    private int count = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1",3000)
    );
}
