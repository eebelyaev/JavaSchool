package lesson06.task06;

import lesson06.task01.Calculator;
import lesson06.task01.CalculatorImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PerformanceProxy implements Calculator {
    private Calculator calculator;

    public PerformanceProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    private boolean isMetricMethod(String methodName, Class<?>[] paramTypes) {
        Method method = null;
        try {
            method = Calculator.class.getMethod(methodName, paramTypes);
            return method.isAnnotationPresent(Metric.class);
        } catch (NoSuchMethodException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int calc(int number) {
        long startTime = System.nanoTime();
        int result = calculator.calc(number);
        if (isMetricMethod("calc", new Class<?>[]{int.class}))
            System.out.println("Время работы метода: " + (System.nanoTime() - startTime) + " (в наносекундах)");
        return result;
    }
}
