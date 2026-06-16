import java.util.Scanner;

public class MathWizard {

    private int callCount = 0;
    private String wizardName = "DefaultWizard";

    public boolean isPrime(int n) {
        callCount++;
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public long factorial(int n) {
        callCount++;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double factorial(double n) {
        callCount++;
        // Stirling's approximation
        return Math.exp(
            (n + 0.5) * Math.log(n) - n + 0.5 * Math.log(2 * Math.PI)
            + 1.0 / (12.0 * n)
        );
    }

    public long fibonacci(int n) {
        callCount++;
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }

    public int gcd(int a, int b) {
        callCount++;
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        callCount++;
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    public long power(int base, int exp) {
        callCount++;
        long result = 1;
        int b = base;
        int e = exp;
        while (e > 0) {
            if (e % 2 == 1) result *= b;
            b *= b;
            e /= 2;
        }
        return result;
    }

    public int getCallCount() {
        return callCount;
    }

    public String getWizardName() {
        return wizardName;
    }

    public void setWizardName(String name) {
        this.wizardName = name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathWizard wizard = new MathWizard();

        System.out.print("Enter name for your MathWizard: ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) {
            wizard.setWizardName(name);
        }

        System.out.println("Welcome, " + wizard.getWizardName() + "!");

        while (true) {
            System.out.println("\n--- MathWizard Operations ---");
            System.out.println("1. Check Prime");
            System.out.println("2. Calculate Factorial (int)");
            System.out.println("3. Calculate Factorial (double - Stirling)");
            System.out.println("4. Calculate Fibonacci");
            System.out.println("5. Calculate GCD");
            System.out.println("6. Calculate LCM");
            System.out.println("7. Calculate Power");
            System.out.println("8. Show Stats (Call Count)");
            System.out.println("9. Exit");
            System.out.print("Choose an option (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an option number.");
                scanner.next(); // clear invalid token
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 9) {
                System.out.println("Goodbye from " + wizard.getWizardName() + "!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer to check if prime: ");
                    if (scanner.hasNextInt()) {
                        int num = scanner.nextInt();
                        boolean prime = wizard.isPrime(num);
                        System.out.println("Is " + num + " prime? " + prime);
                    } else {
                        System.out.println("Invalid integer input.");
                        scanner.next();
                    }
                    break;

                case 2:
                    System.out.print("Enter a non-negative integer for factorial: ");
                    if (scanner.hasNextInt()) {
                        int num = scanner.nextInt();
                        if (num < 0) {
                            System.out.println("Factorial is defined for non-negative integers.");
                        } else {
                            System.out.println("Factorial of " + num + " is: " + wizard.factorial(num));
                        }
                    } else {
                        System.out.println("Invalid integer input.");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter a positive double for factorial (Stirling's approximation): ");
                    if (scanner.hasNextDouble()) {
                        double val = scanner.nextDouble();
                        if (val <= 0) {
                            System.out.println("Stirling's approximation is defined for positive values.");
                        } else {
                            System.out.println("Factorial of " + val + " is: " + wizard.factorial(val));
                        }
                    } else {
                        System.out.println("Invalid double input.");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.print("Enter a non-negative integer for Fibonacci index: ");
                    if (scanner.hasNextInt()) {
                        int num = scanner.nextInt();
                        if (num < 0) {
                            System.out.println("Fibonacci index cannot be negative.");
                        } else {
                            System.out.println("Fibonacci number at index " + num + " is: " + wizard.fibonacci(num));
                        }
                    } else {
                        System.out.println("Invalid integer input.");
                        scanner.next();
                    }
                    break;

                case 5:
                    System.out.print("Enter first integer for GCD: ");
                    if (scanner.hasNextInt()) {
                        int a = scanner.nextInt();
                        System.out.print("Enter second integer for GCD: ");
                        if (scanner.hasNextInt()) {
                            int b = scanner.nextInt();
                            System.out.println("GCD of " + a + " and " + b + " is: " + wizard.gcd(a, b));
                        } else {
                            System.out.println("Invalid integer input.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid integer input.");
                        scanner.next();
                    }
                    break;

                case 6:
                    System.out.print("Enter first integer for LCM: ");
                    if (scanner.hasNextInt()) {
                        int a = scanner.nextInt();
                        System.out.print("Enter second integer for LCM: ");
                        if (scanner.hasNextInt()) {
                            int b = scanner.nextInt();
                            System.out.println("LCM of " + a + " and " + b + " is: " + wizard.lcm(a, b));
                        } else {
                            System.out.println("Invalid integer input.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid integer input.");
                        scanner.next();
                    }
                    break;

                case 7:
                    System.out.print("Enter base (integer): ");
                    if (scanner.hasNextInt()) {
                        int base = scanner.nextInt();
                        System.out.print("Enter exponent (non-negative integer): ");
                        if (scanner.hasNextInt()) {
                            int exp = scanner.nextInt();
                            if (exp < 0) {
                                System.out.println("Exponent must be non-negative.");
                            } else {
                                System.out.println(base + "^" + exp + " is: " + wizard.power(base, exp));
                            }
                        } else {
                            System.out.println("Invalid integer input.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid integer input.");
                        scanner.next();
                    }
                    break;

                case 8:
                    System.out.println("Wizard Name: " + wizard.getWizardName());
                    System.out.println("Total method calls made: " + wizard.getCallCount());
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 9.");
            }
        }
        scanner.close();
    }
}
