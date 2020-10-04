package ru.sberbank.reflection.proxy;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class MainDynamic {
    public static void main(String[] args) {
        Calculator calculator=new CalculatorImpl();
        Calculator proxyCalc = CachedInvocationHandler.proxyFactory(calculator);
        //Calculator proxyCalc = LoggingInvocationHandler.proxyFactory(calculator);

        run(proxyCalc);
        System.out.println(proxyCalc.getClass());
    }

    private static void run(Calculator calculator) {
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(10));
        System.out.println(calculator.calc(8));
        System.out.println(calculator.calc(8));
        System.out.println(calculator.calc(8));
        System.out.println(calculator.calc(10));
        System.out.println(calculator.calc(1));
    }
}
