package lesson01.task02;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(0.1), b = BigDecimal.valueOf(0.2);
        System.out.println(a.add(b));
        double a1 = 0.1D, b1 = 0.2;
        System.out.println(a1 + b1);
    }
}
