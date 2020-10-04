package ru.sberbank.reflection;

import java.lang.reflect.Field;

public class HelloWorld {
    private final String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    private void sayHello(){
        System.out.println("Hello, "+name);
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        HelloWorld hello =new HelloWorld("World");
        Field field = hello.getClass().getDeclaredField("name");

            field.setAccessible(true);
            field.set(hello, "Хуцкер");


    }

}
