package lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    public void testAdd() {
        int result = Task4.MathFunctions.add(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        int result = Task4.MathFunctions.subtract(5, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testMultiply() {
        int result = Task4.MathFunctions.multiply(4, 3);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        int result = Task4.MathFunctions.divide(10, 2);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task4.MathFunctions.divide(10, 0);
        });
    }
}