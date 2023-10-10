package org.example;

import java.util.Random;

/**
 * This is a Java program that demonstrates the Quick Sort algorithm for sorting an array of integers.
 * Quick Sort is a fast and efficient sorting algorithm that works by selecting a 'pivot' element from the array
 * and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
 * The sub-arrays are then recursively sorted.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {

        // Create an integer array to be sorted
//        int[] ar = generateRandomArray(15);

        int[] arr = { 10, 7, 8, 9, 1, 5, 3, 2, 4, 6, 11, 13, 17, 15, 12, 14, 16, 18, 19, 20, 23, 21, 22, 25, 24 };

        // Call the quicksort method to sort the array
        quicksort(arr, 0, arr.length - 1);

        // Print the sorted array
        for (int j : arr) {
            System.out.print(" " + j);
        }
    }

    /**
     * Generates an array of random integers.
     *
     */
    public static int[] generateRandomArray(int size) {
        // Create an array to hold the random integers
        int[] randomArray = new int[size];

        // Create a Random object to generate random numbers
        Random rand = new Random();

        // Loop through the array to populate it with random integers
        for (int i = 0; i < size; i++) {
            // Generate a random integer between 0 and 99 (inclusive) and store it in the array
            randomArray[i] = rand.nextInt(100); // Adjust the range as needed
        }

        // Return the generated array
        return randomArray;
    }

    /**
     * The quicksort method sorts an array of integers using the Quick Sort algorithm.
     *
     * @param arr  The array to be sorted.
     * @param low  The index of the low boundary of the current partition.
     * @param high The index of the high boundary of the current partition.
     */
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array into two sub-arrays
            int part = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quicksort(arr, low, part - 1);
            quicksort(arr, part + 1, high);
        }
    }

    /**
     * The partition method partitions an array into two sub-arrays
     * and returns the index of the pivot element.
     *
     * @param arr  The array to be partitioned.
     * @param low  The index of the low boundary of the current partition.
     * @param high The index of the high boundary of the current partition.
     * @return The index of the pivot element.
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1;

        // Iterate through the array and move elements less than the pivot to the left
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);

//                // Swap arr[i] and arr[j]
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
            }
        }

        swap(arr, i + 1, high);

//        // Swap the pivot element with arr[i+1] to place it in the correct position
//        int temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;

        // Return the index of the pivot element
        return i + 1;
    }

    /**
     * Swaps two elements in an integer array.
     *
     * @param arr The integer array in which elements will be swapped.
     * @param i   The index of the first element to be swapped.
     * @param j   The index of the second element to be swapped.
     */
    public static void swap(int[] arr, int i, int j) {
        // Store the value of ar[i] in a temporary variable 'temp'
        int temp = arr[i];

        // Assign the value of ar[j] to ar[i]
        arr[i] = arr[j];

        // Assign the value stored in 'temp' (which was ar[i] before the swap) to ar[j]
        arr[j] = temp;
    }

}
