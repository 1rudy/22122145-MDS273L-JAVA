import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Select an operation to perform:");
        System.out.println("1. Find the Mean Value");
        System.out.println("2. Find the Median Value");
        System.out.println("3. Find the Mode Value");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                double mean = findMean(arr);
                System.out.println("Mean: " + mean);
                break;
            case 2:
                double median = findMedian(arr);
                System.out.println("Median: " + median);
                break;
            case 3:
                int mode = findMode(arr);
                System.out.println("Mode: " + mode);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static double findMean(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }

    public static double findMedian(int[] arr) {
        Arrays.sort(arr);
        int middle = arr.length / 2;
        if (arr.length % 2 == 1) {
            return arr[middle];
        } else {
            return (arr[middle - 1] + arr[middle]) / 2.0;
        }
    }

    public static int findMode(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 1;
        int mode = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
                if (count > maxCount) {
                    maxCount = count;
                    mode = num;
                }
            } else {
                map.put(num, 1);
            }
        }

        return mode;
    }
}