package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Scientific Calculator, Choose an option to perform corresponding operations");
            System.out.print("Press 1 to find the Factorial of a number\nPress 2 to find the Square Root of a number\nPress 3 to find the Power\nPress 4 to find thr Natural Logarithm\n" +
                    "Press 5 to exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // find the factorial
                    System.out.print("Enter a number : ");
                    double num;
                    num = scanner.nextDouble();
                    System.out.println("Factorial of the number"+num+" is : " + calculator.fact(num));
                    System.out.println("\n");

                    break;
                case 2:
                    // find square root
                    System.out.print("Enter a number : ");
                    double root;
                    root = scanner.nextDouble();
                    System.out.println("Square root of the "+root+" is : " + calculator.sqroot(root));
                    System.out.println("\n");
                    break;
                case 3:
                    // find the power
                    System.out.print("Enter the first number : ");
                    double num1, num2;
                    num1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    num2 = scanner.nextDouble();
                    System.out.println(num1+ " raised to power "+num2+" is : " + calculator.power(num1, num2));
                    System.out.println("\n");
                    break;
                case 4:
                    // find the natural log
                    System.out.print("Enter a number : ");
                    double n;
                    n = scanner.nextDouble();
                    System.out.println("Natural log of "+n+" is : " + calculator.naturalLog(n));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting from the calculator....");
                    return;
            }
        } while (true);
    }


    public double fact(double num) {
        logger.info("[FACTORIAL] - " + num);
        double result = factorial(num);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }



    public double sqroot(double num) {
        logger.info("[SQ ROOT] - " + num);
        double result = Math.sqrt(num);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }


    public double power(double num1, double num2) {
        logger.info("[POWER - " + num1 + " RAISED TO] " + num2);
        double result = Math.pow(num1,num2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double num) {
        logger.info("[NATURAL LOG] - " + num);
        double result = 0;
        try {

            if (num <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(num);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
    public double factorial(double num) {
        double result = 1;
        for(int i = 1; i <= num; ++i)
            result *= i;
        return  result;
    }
}