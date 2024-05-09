package lab1;

/**
 * This class represents a Task5 object.
 */
public class Task5 {

    /**
     * This class represents a Calculator object.
     */
    public static class Calculator {

        /**
         * Adds two numbers.
         *
         * @param a the first number
         * @param b the second number
         * @return the sum of the two numbers
         */
        public static int add(int a, int b) {
            return a + b;
        }

        /**
         * Subtracts two numbers.
         *
         * @param a the first number
         * @param b the second number
         * @return the difference between the two numbers
         */
        public static int subtract(int a, int b) {
            return a - b;
        }

        /**
         * Multiplies two numbers.
         *
         * @param a the first number
         * @param b the second number
         * @return the product of the two numbers
         */
        public static int multiply(int a, int b) {
            return a * b;
        }

        /**
         * Divides two numbers.
         *
         * @param a the dividend
         * @param b the divisor
         * @return the quotient of the two numbers
         * @throws IllegalArgumentException if the divisor is zero
         */
        public static int divide(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return a / b;
        }
    }
}
