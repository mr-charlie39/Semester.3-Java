import java.util.Scanner;

class MergeSort {

    // Merge two sorted parts of the array
    void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        // Compare elements from both halves
        while (i <= mid && j <= end) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from right half
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy sorted elements back into original array
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
        }
    }

    // Merge Sort
    public void mergeSort(int[] arr, int start, int end) {

        if (start < end) {

            int mid = start + (end - start) / 2;

            // Sort left half
            mergeSort(arr, start, mid);

            // Sort right half
            mergeSort(arr, mid + 1, end);

            // Merge both sorted halves
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array you want to enter: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Input array
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element at index " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        // Create object
        MergeSort mergeSort = new MergeSort();

        // Apply Merge Sort
        mergeSort.mergeSort(arr, 0, size - 1);

        // Print sorted array
        System.out.println("\nSorted Array:");

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}