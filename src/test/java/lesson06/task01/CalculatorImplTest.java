package lesson06.task01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {

    @Test
    void calc() {
        Calculator calculator = new CalculatorImpl();
        Assertions.assertEquals(120, calculator.calc(5));
        Assertions.assertEquals(720, calculator.calc(6));
        Assertions.assertEquals(0, calculator.calc(-1));
    }
}