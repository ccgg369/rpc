package com.zhongyou.server;

import com.zhongyou.ccrpc.Request;
import com.zhongyou.ccrpc.ServiceDescriptor;
import com.zhongyou.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露服务
 *
 * @author ccx
 * @date 2020/6/14 14:37
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfacesClass, T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(interfacesClass);
        for (Method method : methods){
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfacesClass,method);

            services.put(sdp,sis);
            log.info("register service: {} {}",sdp.getClazz(),sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
