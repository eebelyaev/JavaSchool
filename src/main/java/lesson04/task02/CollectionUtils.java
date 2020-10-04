package lesson04.task02;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static void main(String[] args) {
        List<Integer> integers = CollectionUtils.newArrayList();
        integers.add(5);
        System.out.println("integers.add(5)");
        System.out.println("integers = " + integers);

        List<Number> numbers = CollectionUtils.newArrayList();
        CollectionUtils.addAll(integers, numbers);
        numbers.add(7);
        System.out.println("numbers = " + numbers + ", get(0) = " + numbers.get(0));

        System.out.println("CollectionUtils.indexOf(numbers, 7) = " + CollectionUtils.indexOf(numbers, 7));

        List<Integer> limIntegers = CollectionUtils.limit(integers, 0);
        System.out.println("CollectionUtils.limit(integers, 0) = " + limIntegers);

        List<Number> limNumbers = CollectionUtils.limit(numbers, 2);
        System.out.println("CollectionUtils.limit(numbers, 2) = " + limNumbers);

        CollectionUtils.add(integers, 10);
        CollectionUtils.add(integers, 20);
        System.out.println("CollectionUtils.add(integers, 10); CollectionUtils.add(integers, 20);");
        System.out.println("integers = " + integers);

        CollectionUtils.removeAll(numbers, integers);
        System.out.println(numbers);

        CollectionUtils.add(numbers, 5);
        CollectionUtils.add(numbers, 10);
        CollectionUtils.add(numbers, 20);
        System.out.println("numbers = " + numbers);

        System.out.println("(numbers in integers) = " + CollectionUtils.containsAll(integers, numbers));
        System.out.println("(integers in numbers) = " + CollectionUtils.containsAll(numbers, integers));

        integers.subList(0, 2).replaceAll(x -> x + 1);
        System.out.println("integers = " + integers);
        System.out.println("(numbers in integers) = " + CollectionUtils.containsAny(integers, numbers));
        System.out.println("(integers in numbers) = " + CollectionUtils.containsAny(numbers, integers));

        System.out.println("[5, 10]: " + CollectionUtils.range(integers, 5, 10));
        System.out.println("[10, 20]: " + CollectionUtils.range(integers, 10, 20));
        integers = CollectionUtils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6);
        System.out.println(integers);

        Comparator<String> comparator = ((o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2));
        List<String> strings = Arrays.asList("55555", "1", "333", "22");
        System.out.println(CollectionUtils.range(strings, "2", "3334", comparator));
    }

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        List<T> dest = newArrayList();
        dest.addAll(source.stream().limit(size).collect(Collectors.toList()));
        return dest;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T o : c2) removeFrom.remove(o);
    }

    /**
     * true если первый лист содержит все элементы второго
     */
    public static boolean containsAll(List<?> c1, List<?> c2) {
        return c1.containsAll(c2);
    }

    /**
     * true если первый лист содержит хотя-бы 1 второго
     */
    public static boolean containsAny(List<?> c1, List<?> c2) {
        for (Object o : c2)
            if (c1.contains(o)) return true;
        return false;
    }

    /**
     * Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     * Элементы сравнивать через Comparable.
     * Пример range(Arrays.asList(8,1,3,5,6,4), 3, 6) вернет {3,4,5,6}
     */
    public static <T extends Object & Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        return list.stream().filter(o -> o.compareTo(min) >= 0 && o.compareTo(max) <= 0).collect(Collectors.toList());
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        return list.stream().filter(o -> comparator.compare(o, min) >= 0 && comparator.compare(o, max) <= 0).collect(Collectors.toList());
    }
}
