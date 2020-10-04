package ru.sberbank.reflection;

import java.lang.reflect.Field;

public class ReflectionHelper {

    public static void changePrivateStringField(Object object, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (field.getType().isInstance(newValue)) {
            field.setAccessible(true);
            field.set(object, newValue);
        } else {
            throw new IllegalArgumentException("Типы не совпадают");
        }
    }

    public static boolean checkValueNotNull(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field: fields){
            field.setAccessible(true);
            if(field.get(object)==null){
                return false;
            }
        }
        return true;
    }

    public static void copyObject(Object obj1, Object obj2) throws IllegalAccessException {
        if(obj1.getClass() != obj2.getClass()){
            throw new IllegalArgumentException("Объекты разных типов");
        }
        Field[] fields=obj1.getClass().getDeclaredFields();
        for(Field field: fields){
            field.setAccessible(true);
            Object fieldValue= field.get(obj1);
            field.set(obj2,fieldValue);
        }
    }

    public static void validateStringLength(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        for(Field field: clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ValidLength.class) && field.getType() == String.class){
                ValidLength ab = field.getAnnotation(ValidLength.class);
                int max = ab.max();
                int min = ab.min();
                String value= field.get(object).toString();
                if(value.length()<min || value.length()>max){
                    throw new IllegalStateException(field.getName() + " длина данного поля должна быть в промежутке "+ min + " - "+ max);
                }
            }
        }
    }
}
