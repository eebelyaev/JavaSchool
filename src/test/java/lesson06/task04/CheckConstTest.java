package lesson06.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckConstTest {
    /**
     * Задача 4:
     * Проверить что все String константы имеют значение = их имени
     * public static final String MONDAY = "MONDAY";
     */
    @Test
    void task04() {
        A1 a1 = new A1();
        A2 a2 = new A2();
        try {
            Assertions.assertTrue(CheckConst.task04(a1));
            Assertions.assertFalse(CheckConst.task04(a2));
        } catch (IllegalAccessException e) {
            System.err.println(e.getStackTrace());
        }
    }
}

class A1 {
    private int intFieldA;
    public static final String SUNDAY = "SUNDAY";
    public static final String MONDAY = "MONDAY";
    public final String MONDAY2 = "MONDAY";
    private final String MONDAY3 = "MONDAY";
    private static final String MONDAY4 = "MONDAY";
}

class A2 {
    private int intFieldA;
    public static final String SUNDAY = "SUNDAY";
    public static final String MONDAY = "MONDAY_";
    public final String MONDAY2 = "MONDAY";
    private final String MONDAY3 = "MONDAY";
    private static final String MONDAY4 = "MONDAY";
}