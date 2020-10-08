package lesson10.task02;

/**
 * 2) Опишите функциональный интерфейс, который позволит выполнить следующий код:
 * MyLambda<String> myLambda1 = (a, b) -> a + b;
 * MyLambda<Integer> myLambda2 = (a, b) -> a + b;
 * System.out.println(myLambda1.getSum("abc", "def"));
 * System.out.println(myLambda2.getSum(1, 1));
 */
@FunctionalInterface
public interface MyLambda<T> {
    T getSum(T a, T b);
}
