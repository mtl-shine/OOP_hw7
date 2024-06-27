package view;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public String getNumber(String title) {
        System.out.printf("%s", title);
        return scanner.nextLine();
    }

    public void printResult(String title, String a, String b, String res) {
    System.out.println(title + a + " and " + b + " is " + res);
    }

    public String getOperationChoice() {
        System.out.println("Please, choose the operation you'd like to perform:\n1 - Addition\n2 - Multiplication\n3 - Division");
        return scanner.nextLine();
    }

    public void printCalculationError() {
        System.out.println("Something went wrong. Perhaps you have tried to calculate a complex number with a real number.");
    }

    public void printInputError() {
        System.out.println("Something went wrong. Please check the input data.");
    }

    public String askToContinue() {
        System.out.println("Would you like to continue?\n1 - Yes\n2 - No");
        return scanner.nextLine();
    }

}
