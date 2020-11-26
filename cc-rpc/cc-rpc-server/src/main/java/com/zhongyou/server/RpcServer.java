package com.zhongyou.server;

import com.zhongyou.ccrpc.Request;
import com.zhongyou.ccrpc.Response;
import com.zhongyou.codec.Decoder;
import com.zhongyou.codec.Encoder;
import com.zhongyou.common.utils.ReflectionUtils;
import com.zhongyou.transport.HttpTransportServer;
import com.zhongyou.transport.RequestHandler;
import com.zhongyou.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ccx
 * @date 2020/6/14 16:28
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(RpcServerConfig config){
        this.config = config;

        // net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.hanlder);

        // codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        // service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public RpcServer() {

    }

    public <T>  void register(Class<T> interfacesClass, T bean){
        ServiceManager serviceManager1 = new ServiceManager();
        serviceManager1.register(interfacesClass,bean);
    }

    public void start(){
        TransportServer net1 = new HttpTransportServer();
        net1.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler hanlder = new RequestHandler() {
        @Override
        public void onRequest(InputStream recive, OutputStream toResp) {
            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(recive, recive.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("get request: {}", request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis,request);
                resp.setData(ret);
            } catch (Exception e) {
                log.warn(e.getMessage(),e);
                resp.setCode(1);
                resp.setMessage("RpcServer got error: " + e.getClass().getName()
                        +  " ：" + e.getMessage());
                e.printStackTrace();
            }finally {
                try {
                    byte[] outBytes = encoder.encode(resp);
                    toResp.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                }
            }
        }
    };
}
