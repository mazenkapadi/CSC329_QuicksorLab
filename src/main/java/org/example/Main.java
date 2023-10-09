package org.example;

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
        int[] ar = {5, 2, 1, 3, 4};

        // Call the quicksort method to sort the array
        quicksort(ar, 0, ar.length - 1);

        // Print the sorted array
        for (int j : ar) {
            System.out.print(" " + j);
        }
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
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with arr[i+1] to place it in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the index of the pivot element
        return i + 1;
    }















}
