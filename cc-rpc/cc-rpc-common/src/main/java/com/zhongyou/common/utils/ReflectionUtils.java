package com.zhongyou.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *  反射工具类
 *  @author ccx
 *  @date 2020/6/10 12:30
 */
public class ReflectionUtils {
    public static <T> T newInstance(Class<T> clazz){
        /**
         *  根据class创建对象
         *   clazz 待创建的对象
         */
        try {
            return clazz.newInstance();
        } catch (Exception e) {
           throw  new IllegalStateException(e);
        }
    }

    /**
     *  获取某个class的共有方法
     *  @param clazz
     *  @return
     */
    public static Method[] getPublicMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = new ArrayList<>();
        for (Method m : methods){
            if(Modifier.isPublic(m.getModifiers())){
                pmethods.add(m);
            }
        }
        return pmethods.toArray(new Method[0]);
    }

    /**
     *  调用指定对象的指定方法
     *  @param obj 被调用方法的对象
     *  @param method
     *  @param args
     *  @return
     */
    public static Object invoke(Object obj,Method method,Object... args){
        try {
            return method.invoke(obj,args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
