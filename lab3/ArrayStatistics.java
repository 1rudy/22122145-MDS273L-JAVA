package lab3;

import java.util.*;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("1. Find the Mean Value");
        System.out.println("2. Find the Median Value");
        System.out.println("3. Find the Mode Value");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                double mean = findMean(array);
                System.out.println("Mean Value: " + mean);
                break;
            case 2:
                double median = findMedian(array);
                System.out.println("Median Value: " + median);
                break;
            case 3:
                int mode = findMode(array);
                System.out.println("Mode Value: " + mode);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();
    }
    
    public static double findMean(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
    
    public static double findMedian(int[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            int middle = array.length / 2;
            return (array[middle - 1] + array[middle]) / 2.0;
        } else {
            int middle = array.length / 2;
            return array[middle];
        }
    }
    
    public static int findMode(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (frequencyMap.containsKey(key)) {
                frequencyMap.put(key, frequencyMap.get(key) + 1);
            } else {
                frequencyMap.put(key, 1);
            }
        }
        int mode = -1;
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = entry.getKey();
            }
        }
        return mode;
    }
}
    
}
