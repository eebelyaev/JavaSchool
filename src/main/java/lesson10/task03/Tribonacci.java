package lesson10.task03;

import java.util.stream.Stream;

/**
 * 3) С помощью lambda и Stream API реализуйте метод для генерации чисел трибоначчи
 * (да, именно «трибоначчи», не Фибоначчи) до n-го члена последовательности.
 */
public class Tribonacci {
    public static void print(int n) {
        if (n <= 3) throw new RuntimeException("Число должно быть больше 3");

        System.out.print("\nПоследовательность Трибоначчи: 0 0");
        Stream.iterate(new int[]{0, 0, 1}, x -> new int[]{x[1], x[2], x[0] + x[1] + x[2]})
                .limit(n - 1)
                .map(x -> x[2])
                .forEach(x -> System.out.print(" " + x));
    }

    public static void main(String[] args) {
        print(15);
    }
}
