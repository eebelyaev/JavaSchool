package ru.sberbank.reflection.proxy;


public interface Calculator {
    @Cache
    int calc(int arg);
}
