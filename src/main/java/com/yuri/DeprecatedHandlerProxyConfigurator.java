package com.yuri;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceProxyIfNeeded(Object t, Class implClass) {

        if (implClass.isAnnotationPresent(Deprecated.class)) {

            long count = Arrays.stream(implClass.getInterfaces()).filter(i -> i.getDeclaredMethods().length != 0).count();
            if (count == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (o, method, args) -> getInvocationHandlerLogic(t, method, args));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(t, method, args));
        } else {
            return t;
        }
    }

    private Object getInvocationHandlerLogic(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.printf("Usage of deprecated method %s(%s) in class %s\n",
                method.getName(),
                Stream.of(method.getParameterTypes()).map(Class::getCanonicalName).collect(Collectors.joining(",")),
                t.getClass().getName());
        return method.invoke(t, args);
    }
}
