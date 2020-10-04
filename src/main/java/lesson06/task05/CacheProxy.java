package lesson06.task05;

import lesson06.task01.Calculator;
import lesson06.task01.CalculatorImpl;

import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements Calculator {
    private Map<Integer, Integer> cache;
    private Calculator calculator;

    public CacheProxy() {
        cache = new HashMap<>();
        calculator = new CalculatorImpl();
    }

    @Override
    public int calc(int number) {
        if (cache.containsKey(number)) return cache.get(number);
        int result = calculator.calc(number);
        cache.put(number, result);
        return result;
    }
}
