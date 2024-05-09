package lab1;

public class Task4 {
    public static class MathFunctions {
        // Method to add two numbers
        public static int add(int a, int b) {
            return a + b;
        }

        // Method to subtract two numbers
        public static int subtract(int a, int b) {
            return a - b;
        }

        // Method to multiply two numbers
        public static int multiply(int a, int b) {
            return a * b;
        }

        // Method to divide two numbers
        public static int divide(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return a / b;
        }
    }

    public static void main(String[] args) {
        MathFunctions math = new MathFunctions();
        int a = 10;
        int b = 5;
        System.out.println("Addition: " + math.add(a, b));
        System.out.println("Subtraction: " + math.subtract(a, b));
        System.out.println("Multiplication: " + math.multiply(a, b));
        System.out.println("Division: " + math.divide(a, b));
    }
}
