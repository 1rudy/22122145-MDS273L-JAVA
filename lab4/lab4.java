import java.util.Scanner;

public class lab4 {
    static int accountNumber;
    static String accountHolderName;
    static double accountBalance;

    static void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        accountNumber = input.nextInt();
        input.nextLine();
        System.out.println("Enter Account Holder Name:");
        accountHolderName = input.nextLine();
        System.out.println("Enter Account Balance:");
        accountBalance = input.nextDouble();
    }

    static void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Amount to Deposit:");
        double amount = input.nextDouble();
        accountBalance += amount;
        System.out.println("Deposit Successful. New Balance: " + accountBalance);
    }

    static void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Amount to Withdraw:");
        double amount = input.nextDouble();
        if (accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println("Withdrawal Successful. New Balance: " + accountBalance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    static void printTransactions() {
        System.out.println("No Transactions Available.");
    }

    static void printAccountSummary() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        createAccount();

        do {
            System.out.println("\nMenu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Transactions");
            System.out.println("4. Print Account Summary");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    printTransactions();
                    break;
                case 4:
                    printAccountSummary();
                    break;
                case 0:
                    System.out.println("Exiting Program.");
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again.");
                    break;
            }
        } while (choice != 0);
    }
}