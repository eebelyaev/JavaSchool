package lesson06.task04;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CheckConst {
    /**
     * Задача 4:
     * Проверить что все String константы имеют значение = их имени
     * public static final String MONDAY = "MONDAY";
     */
    public static <T> boolean task04(T object) throws IllegalAccessException {
        int mask = Modifier.FINAL | Modifier.PUBLIC | Modifier.STATIC;
        for (Field field : object.getClass().getFields()) {
            if ((field.getModifiers() & mask) == mask
                    && field.getType().equals(String.class)
                    && !field.getName().equals(field.get(object))
            ) return false;
        }
        return true;
    }
}
