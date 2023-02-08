import java.util.Scanner;

public class Lab2 {
    static final int OUTPUT ;
    static String[] names = new String[OUTPUT];
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Enter a name");
            System.out.println("2. Search for a name");
            System.out.println("3. Remove a name");
            System.out.println("4. Show all names");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    enterName(input);
                    break;
                case 2:
                    searchName(input);
                    break;
                case 3:
                    removeName(input);
                    break;
                case 4:
                    showAllNames();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    public static void enterName(Scanner input) {
        System.out.print("Enter a name: ");
        String name = input.next();
        if (isDuplicate(name)) {
            System.out.println("Name already exists. Enter a unique name.");
            return;
        }
        names[count++] = name;
        System.out.println("Name added successfully.");
    }

    public static void searchName(Scanner input) {
        System.out.print("Enter a name to search: ");
        String name = input.next();
        int index = findName(name);
        if (index == -1) {
            System.out.println("Name not found.");
        } else {
            System.out.println("Name found at index " + index + ".");
        }
    }

    private static int findName(String name) {
        return 0;
    }

    public static void removeName(Scanner input) {
        System.out.print("Enter a name to remove: ");
        String name = input.next();
        int index = findName(name);
        if (index == -1) {
            System.out.println("Name not found.");
        } else {
            for (int i = index; i < count - 1; i++) {
                names[i] = names[i + 1];
            }
            count--;
            System.out.println("Name removed successfully.");
        }
    }

    public static void showAllNames() {
        System.out.println("All names: ");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
    }

    public static boolean isDuplicate(String name) {
        for (int i = 0; i < count; i++) {
            if (name