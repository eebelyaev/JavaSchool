package lesson01.task02;

import java.io.IOException;
import java.util.Scanner;

public class TemperatureConversion {
    private static double conversionCToF(double t) {
        return 9. / 5. * t + 32;
    }

    private static double conversionFToC(double t) {
        return 5. / 9. * (t - 32);
    }

    private static double getTemperature() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Введите число: ");
        }
        double d = scanner.nextDouble();
        //scanner.close();
        return d;
    }

    public static void main(String[] args) throws IOException {

        double temp = 0;
        System.out.print("Введите температуру в Цельсиях: ");
        temp = getTemperature();
        System.out.println("Температура в Цельсиях: " + temp + ", в Фаренгейтах = " + conversionCToF(temp));

        System.out.print("Введите температуру в Фаренгейтах: ");
        temp = getTemperature();
        System.out.println("Температура в Фаренгейтах = " + temp + ", в Цельсиях = " + conversionFToC(temp));
    }
}
