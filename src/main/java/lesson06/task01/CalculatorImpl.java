package lesson06.task01;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        if (number < 1) return 0;
        else if (number > 1) return number * calc(number - 1);
        else return 1;
    }
}
