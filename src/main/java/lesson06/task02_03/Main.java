package lesson06.task02_03;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;


public class Main {
    public static void main(String[] args) {
        task02();
        task03();
    }

    private static String getMethodSignature(Method method) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(method.getName() + "(");
        for (Parameter parameter : method.getParameters()) {
            buffer.append(" " + parameter.getType().getName());
        }
        return buffer.toString() + " )";
    }

    /**
     * Задача 2:
     * Вывести на консоль все методы класса, включая все родительские методы (включая приватные)
     */
    private static void task02() {
        System.out.println("Task02");
        // все непубличные методы суперкласса
        for (Method method : B.class.getSuperclass().getDeclaredMethods()) {
            if ((method.getModifiers() & Modifier.PUBLIC) == 0) {
                System.out.println(getMethodSignature(method));
            }
        }
        // все непубличные методы класса
        for (Method method : B.class.getDeclaredMethods()) {
            if ((method.getModifiers() & Modifier.PUBLIC) == 0) {
                System.out.println(getMethodSignature(method));
            }
        }
        // все доступные методы класса
        for (Method method : B.class.getMethods()) {
            System.out.println(getMethodSignature(method));
        }
    }

    /**
     * Задача 3:
     * Вывести все геттеры класса
     */
    private static void task03() {
        System.out.println("\nTask03: Getters of class " + B.class.getName());
        for (Method method : B.class.getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0)
                System.out.println(method.getName());
        }
    }
}