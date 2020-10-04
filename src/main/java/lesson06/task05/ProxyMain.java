package lesson06.task05;

import lesson06.task01.Calculator;


public class ProxyMain {
    /**
     * Задача 5:
     * Реализовать кэширующий прокси
     *
     * @param args
     */
    public static void main(String[] args) {
        Calculator calculator = new CacheProxy();
        //Calculator calculator = new CalculatorImpl();
        long startTime = System.nanoTime();
        System.out.println("10! = " + calculator.calc(10));
        System.out.println("12! = " + calculator.calc(12));
        System.out.println("10! = " + calculator.calc(10));
        System.out.println("10! = " + calculator.calc(10));
        System.out.println("Прошло времени: " + (System.nanoTime() - startTime) / 1000000000);
    }
}
