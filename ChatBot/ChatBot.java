package ChatBot;

import java.util.Scanner;

public class ChatBot {

    static String name, option, answer, item;
    static int quantity, days;
    static double price, total;
    static boolean result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hello! Welcome to your chat bot. Please enter your name: ");
        name = input.next();

        System.out.print("What would you like help with (sales / service / tech_support)? ");
        option = input.next().toLowerCase();

        switch (option) {
            case "sales":
                total = sales();
                printTotalCost();
                break;
            case "service":
                service();
                break;
            case "tech_support":
                techSupport();
                printTechSupportAnswer();
                break;
            default:
                System.out.println("Error: invalid selection");
        }
        chatSummary();
    }

    public static double sales() {
        Scanner input = new Scanner(System.in);

        System.out.print("What would you like to buy? ");
        item = input.next();

        price = (double) (Math.random() * 5000) + 100;
        System.out.printf("The price is $%.2f. How many would you like to purchase? ", price);
        quantity = input.nextInt();

        total = price * quantity;
        return total;
    }

    public static void printTotalCost() {
        System.out.printf("Your total for %d %s(s) is $%.2f\n", quantity, item, total);
    }

    public static int service() {
        Scanner input = new Scanner(System.in);
        days = (int) (Math.random() * 15) + 3;

        System.out.print("What is the problem? ");
        answer = input.next().toLowerCase();

        if ("nothing".equals(answer)) {
            System.out.println("There is no problem.");
        } else {
            printServiceDays();
        }
        return days;
    }

    public static void printServiceDays() {
        if ("nothing".equals(answer)) {
            System.out.println("There is no problem.");
        } else {
            System.out.printf("We will make a service call in %d days.\n", days);
        }
    }

    public static boolean techSupport() {    // I had a lot of trouble here - I'm still not completely sure I got it, but it seems to work
        Scanner input = new Scanner(System.in);

        System.out.print("Have you turned the machine off and on again? ");
        answer = input.next().toLowerCase();

        if ("yes".equals(answer)) {
            result = true;
        }
        return result;
    }

    public static void printTechSupportAnswer() {
        if ("yes".equals(answer)) {
            System.out.println("No <3");
        } else {
            System.out.println("Try that, and come back.");
        }
    }

    public static void chatSummary() {
        System.out.printf("Chat Summary\nName: %s\nOption: %s\n", name, option);

        switch (option) {
            case "sales":
                printTotalCost();
                break;
            case "service":
                printServiceDays();
                break;
            default:
                printTechSupportAnswer();
        }
    }
}