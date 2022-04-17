package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    // funtion to return square root of the number
    public double sqroot(double num) {
        double result;
        if(num < 0 ) {
            logger.info("Square root of negative number doesn't exists");
            result = Double.NaN;
        }
        else result = Math.sqrt(num);
        return result;
    }

    // funtion to return factorial of the number
    public double factorial(double num) {
        double result;
        if(num < 0) {
            logger.info("Factorial of negative number doesn't exists");
            result = Double.NaN;
        }
        else {
            result = 1;
            for(double i=1;i<=num;i++)
                result = result * i;
        }
        return result;
    }

    // funtion to return natural log of the number
    public double nlog(double num) {
        double result;
        if(num < 0) {
            logger.info("Natural Log of negative numbers doesn't exists");
            result = Double.NaN;
        }
        else result = Math.log(num);
        return result;
    }

    // funtion to return x raised to the power a
    public double power(double x, double a) {
        double result;
        result = Math.pow(x, a);
        return result;
    }



    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Scientific Calculator, Choose an option to perform corresponding operations");
            System.out.println("Press 1 to find the Square Root of a number");
            System.out.println("Press 2 to find the Factorial of a number");
            System.out.println("Press 3 to find the Natural Log of a number");
            System.out.println("Press 4 to find power of a raise to b");
            System.out.println("Press 5 to exit...");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            if (choice == 1) {
                System.out.print("Enter a number : ");
                double root;
                root = scanner.nextDouble();
                System.out.println("Square root of the " + root + " is : " + calculator.sqroot(root));
                System.out.println("\n");
            } else if (choice == 2) {
                System.out.print("Enter a number : ");
                double num;
                num = scanner.nextDouble();
                System.out.println("Factorial of the number" + num + " is : " + calculator.factorial(num));
                System.out.println("\n");
            } else if (choice == 3) {
                System.out.print("Enter a number : ");
                double n;
                n = scanner.nextDouble();
                System.out.println("Natural log of " + n + " is : " + calculator.nlog(n));
                System.out.println("\n");
            } else if (choice == 4) {
                System.out.print("Enter the first number : ");
                double num1, num2;
                num1 = scanner.nextDouble();
                System.out.print("Enter the second number : ");
                num2 = scanner.nextDouble();
                System.out.println(num1 + " raised to power " + num2 + " is : " + calculator.power(num1, num2));
                System.out.println("\n");
            } else if (choice == 5) {
                System.out.println("Exiting from the calculator....");
                break;
            }
        } while (true);
    }
}