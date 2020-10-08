package lesson10.task02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLambdaTest {

    @Test
    void getSum() {
        MyLambda<String> myLambda1 = (a, b) -> a + b;
        MyLambda<Integer> myLambda2 = (a, b) -> a + b;
        //System.out.println(myLambda1.getSum("abc", "def"));
        //System.out.println(myLambda2.getSum(1, 1));
        Assertions.assertEquals(myLambda1.getSum("abc", "def"), "abcdef");
        Assertions.assertEquals(myLambda2.getSum(1, 1), 2);
    }
}