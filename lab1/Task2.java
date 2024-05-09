package lab1;

// Default code
// public class PasswordValidator {
//     public static boolean isValidPassword(String password) {
//     if (password.length() < 8) {
//     return false;
//     }
//     boolean hasUpperCase = false;
//     boolean hasLowerCase = false;
//     boolean hasNumber = false;
//     for (char c : password.toCharArray()) {
//     if (Character.isUpperCase(c)) {
//     hasUpperCase = true;
//     } else if (Character.isLowerCase(c)) {
//     hasLowerCase = true;
//     } else if (Character.isDigit(c)) {
//     hasNumber = true;
//     }
//     }
//     return hasUpperCase && hasLowerCase && hasNumber;
//     }
//     public static void main(String[] args) {
//     String password = "veryStrongP@ss";
//     boolean valid = isValidPassword(password);
//     System.out.println("Password is valid: " + valid);
//     }
/**
 * This class represents a password validator.
 */
public class Task2 {

    /**
     * Checks if a password is valid.
     * 
     * @param password The password to be validated.
     * @return true if the password is valid, false otherwise.
     */
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;
    }

    /**
     * Main method to test the password validation.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        String password = "veryStrongP@ss1";
        boolean valid = isValidPassword(password);
        System.out.println("Password is valid: " + valid);
    }

}
