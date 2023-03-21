public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the password from the user
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        // Check the length of the password
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Password must be between 8 and 16 characters long");
            return;
        }
        
        // Check the number of character categories
        int categoryCount = 0;
        if (password.matches(".*[a-z].*")) {
            categoryCount++;
        }
        if (password.matches(".*[A-Z].*")) {
            categoryCount++;
        }
        if (password.matches(".*[0-9].*")) {
            categoryCount++;
        }
        if (password.matches(".*[~!@#$%^&*()-=+_].*")) {
            categoryCount++;
        }
        if (categoryCount < 3) {
            System.out.println("Password must contain at least three of the following categories: lower case letters, upper case letters, numbers, special symbols");
            return;
        }
        
        System.out.println("Password is valid");
    }
}

