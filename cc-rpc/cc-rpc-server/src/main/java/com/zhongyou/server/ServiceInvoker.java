package com.zhongyou.server;

import com.zhongyou.ccrpc.Request;
import com.zhongyou.common.utils.ReflectionUtils;

/**
 * 调用具体服务
 *
 * @author ccx
 * @date 2020/6/14 16:26
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request){
       return ReflectionUtils.invoke(service.getTarget(),service.getMethod(),request.getParamters());
    }
}
