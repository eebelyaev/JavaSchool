package lesson04.task02;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        List temp = integers;
        Integer integer = integers.get(0);
        System.out.println(integer);
    }
}
