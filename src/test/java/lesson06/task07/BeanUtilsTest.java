package lesson06.task07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BeanUtilsTest {

    /**
     * to.set(Class0), from.get(Class0)
     * Результат: field3 должно измениться
     */
    @Test
    void assign01() {
        ClassA from = new ClassA1(1, "1", new Class0(1));
        ClassA to = new ClassA1(2, "2", new Class0(2));
        BeanUtils.assign(to, from);
        Assertions.assertEquals(to.field1, 1);
        Assertions.assertEquals(to.field2, "1");
        Assertions.assertEquals(to.field3.f1, 1);
    }

    /**
     * to - отсутствует сеттер, from.get(Class0)
     * Результат: field3 не должно измениться
     */
    @Test
    void assign02() {
        ClassA from = new ClassA1(1, "1", new Class0(1));
        ClassA to = new ClassA(2, "2", new Class0(2));
        BeanUtils.assign(to, from);
        Assertions.assertEquals(to.field1, 1);
        Assertions.assertEquals(to.field2, "1");
        Assertions.assertEquals(to.field3.f1, 2);
    }

    /**
     * to.set(ChildClass0), from.get(Class0)
     * Результат: field3 не должно измениться
     */
    @Test
    void assign03() {
        ClassA from = new ClassA1(1, "1", new Class0(1));
        ClassA to = new ClassA2(2, "2", new Class0(2));
        BeanUtils.assign(to, from);
        Assertions.assertEquals(to.field1, 1);
        Assertions.assertEquals(to.field2, "1");
        Assertions.assertEquals(to.field3.f1, 2);
    }

    /**
     * to.set(Class0), from.get(ChildClass0)
     * Результат: field3 должно измениться
     */
    @Test
    void assign04() {
        ClassA from = new ClassA2(1, "1", new Class0(1));
        ClassA to = new ClassA1(2, "2", new Class0(2));
        BeanUtils.assign(to, from);
        Assertions.assertEquals(to.field1, 1);
        Assertions.assertEquals(to.field2, "1");
        Assertions.assertEquals(to.field3.f1, 1);
    }
}

class Class0 {
    int f1;

    public Class0(int f1) {
        this.f1 = f1;
    }
}

class ChildClass0 extends Class0 {
    public ChildClass0(int f1) {
        super(f1);
    }
}

class ClassA {
    int field1;
    String field2;
    Class0 field3;

    public ClassA(int field1, String field2, Class0 field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public Class0 getField3() {
        return field3;
    }
}

class ClassA1 extends ClassA {

    public ClassA1(int field1, String field2, Class0 field3) {
        super(field1, field2, field3);
    }

    public void setField3(Class0 field3) {
        this.field3 = field3;
    }
}

class ClassA2 extends ClassA {
    public ClassA2(int field1, String field2, Class0 field3) {
        super(field1, field2, field3);
    }

    public void setField3(ChildClass0 field3) {
        this.field3 = field3;
    }
}
