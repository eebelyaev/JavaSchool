package lesson06.task06;

import lesson06.task01.Calculator;
import lesson06.task01.CalculatorImpl;

public class ProxyMain {
    /**
     * Задача 6:
     * Создать свой аннотацию Metric. Реализовать proxy класс PerformanceProxy,
     * который в случае, если метод аннотирован Metric, будет выводить на консоль время выполнения метода.
     *
     * @param args
     */
    public static void main(String[] args) {
        Calculator calculator = new PerformanceProxy(new CalculatorImpl());
        System.out.println(calculator.calc(3));
    }
}
