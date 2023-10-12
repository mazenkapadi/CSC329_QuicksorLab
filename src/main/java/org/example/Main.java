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
        int[] ar = generateRandomArray(15);

        System.out.println("Original array:");

        // Print the contents of the array
        showArray(ar);


        // Call the quicksort method to sort the array
        quicksort(ar, 0, ar.length - 1);

        System.out.println("\nSorted array:");
        // Print the sorted array
        showArray(ar);

        // Call the quicksort method to sort the array


    }

    /**
     * @param size The size of the array to be generated.
     *             <p>
     *             Generates an array of random integers.
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
     * @param a    The array to be sorted.
     * @param low  The index of the low boundary of the current partition.
     * @param high The index of the high boundary of the current partition.
     */
    public static void quicksort(int[] a, int low, int high) {
        if (low < high) {
            // Partition the array into two sub-arrays
            int part = partition(a, low, high);

            // Recursively sort the sub-arrays
            quicksort(a, low, part - 1);
            quicksort(a, part + 1, high);
        }
    }

    /**
     * The partition method partitions an array into two sub-arrays
     * and returns the index of the pivot element.
     *
     * @param a    The array to be partitioned.
     * @param low  The index of the low boundary of the current partition.
     * @param high The index of the high boundary of the current partition.
     * @return The index of the pivot element.
     */
//    public static int partition(int[] a, int low, int high) {   // pivot as high
//        int pivot = a[high]; // Choose the last element as the pivot
//        int i = low - 1;
//
//        // Iterate through the array and move elements less than the pivot to the left
//        for (int j = low; j < high; j++) {
//            if (a[j] < pivot) {
//                i++;
//                swap(a, i, j);
//            }
//        }
//
//        swap(a, i + 1, high);
//
//        // Return the index of the pivot element
//        return i + 1;
//    }
    public static int partition(int[] a, int low, int high) {   //pivot as low
        int pivot = a[low]; // Choose the first element as the pivot
        int i = low + 1;

        // Iterate through the array and move elements less than the pivot to the left
        for (int j = low + 1; j <= high; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, low, i - 1);

        // Return the index of the pivot element
        return i - 1;
    }


    /**
     * Swaps two elements in an integer array.
     *
     * @param a      The integer array in which elements will be swapped.
     * @param index1 The index of the first element to be swapped.
     * @param index2 The index of the second element to be swapped.
     */
    public static void swap(int[] a, int index1, int index2) {
        // Store the value of ar[i] in a temporary variable 'temp'
        int temp = a[index1];

        // Assign the value of ar[j] to ar[i]
        a[index1] = a[index2];

        // Assign the value stored in 'temp' (which was ar[i] before the swap) to ar[j]
        a[index2] = temp;
    }

    /**
     * Prints the contents of an integer array.
     */
    public static void showArray(int[] a) {
        for (int j : a) {
            System.out.print(" " + j);
        }
    }

    public static void checkArrays(int[] a, int[] b) {
        boolean areEqual = true;

        if (a.length != b.length) {
            areEqual = false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    areEqual = false;
                    break;
                }
            }
        }

        if (areEqual) {
            System.out.println("The arrays are equal.");
        } else {
            System.out.println("The arrays are not equal.");
        }
    }

    public static int randomizedPartition(int[] a, int low, int high) {
        Random rand = new Random();
        int i = rand.nextInt(high - low) + low;
        swap(a, i, high);
        return partition(a, low, high);
    }
}
