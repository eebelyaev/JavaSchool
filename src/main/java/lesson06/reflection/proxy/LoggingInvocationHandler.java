package ru.sberbank.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.ClassLoader.getSystemClassLoader;

public class LoggingInvocationHandler implements InvocationHandler {

    private Object delegate;


    public LoggingInvocationHandler(Object delegate) {

        this.delegate = delegate;
    }

    public static <T> T proxyFactory(Object delegate) {
        return (T) Proxy.newProxyInstance(getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new LoggingInvocationHandler(delegate)
        );
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke method:" + method.getName());
        Object object=method.invoke(delegate,args);
        System.out.println("After invoke method:" + method.getName());
        return object;
    }
}
