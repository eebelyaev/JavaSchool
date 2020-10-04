package lesson06.task02_03;

public class A {
    private int intFieldA;

    private void privateMethodA() {
        System.out.println("privateMethodA");
    }

    protected void protectedMethodA() {
        System.out.println("protectedMethodA");
    }

    public int getIntFieldA() {
        return intFieldA;
    }

    public void setIntFieldA(int intFieldA) {
        this.intFieldA = intFieldA;
    }
}

class B extends lesson06.task02_03.A {
    private int intFieldB;

    private void privateMethodB() {
        System.out.println("privateMethodB");
    }

    protected void protectedMethodB() {
        System.out.println("protectedMethodB");
    }

    public int getIntFieldB() {
        return intFieldB;
    }

    public void setIntFieldB(int intFieldB) {
        this.intFieldB = intFieldB;
    }
}