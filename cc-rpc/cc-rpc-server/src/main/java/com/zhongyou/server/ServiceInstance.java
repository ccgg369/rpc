package com.zhongyou.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * 表示一个具体服务
 *
 * @author ccx
 * @date 2020/6/14 14:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
