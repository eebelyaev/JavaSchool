package lesson10.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Напишите свою реализацию класса java.util.stream.Stream, которая позволит
 * выполнить следующий код:
 * Stream<Integer> integerStream = Stream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9)
 * .filter(i -> i%2 == 0)
 * .map(i -> i*i).distinct();
 * integerStream.forEach(System.out::println);
 */
public class MyStream<T> {
    private final List<T> list;

    public static void main(String[] args) {
        MyStream<Integer> integerStream = MyStream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i).distinct();
        integerStream.forEach(System.out::println);
    }

    public MyStream() {
        this.list = new ArrayList<T>();
    }

    public static <T> MyStream<T> of(T... values) {
        MyStream<T> myStream = new MyStream<>();
        myStream.list.addAll(Arrays.asList(values));
        return myStream;
    }

    public MyStream<T> filter(Predicate<? super T> predicate) {
        MyStream<T> myStream = new MyStream<>();
        for (T t : list)
            if (predicate.test(t)) myStream.list.add(t);
        return myStream;
    }

    public <R> MyStream<R> map(Function<? super T, ? extends R> function) {
        MyStream<R> myStream = new MyStream<>();
        for (T t : list) myStream.list.add(function.apply(t));
        return myStream;
    }

    public MyStream<T> distinct() {
        MyStream<T> myStream = new MyStream<>();
        for (T t : list) if (!myStream.list.contains(t)) myStream.list.add(t);
        return myStream;
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : list) consumer.accept(t);
    }
}
