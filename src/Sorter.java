import java.util.Random;

//Handles sorting operations
public class Sorter {
//Chosen basic sorting algorithm: Bubble Sort.

    public void basicSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // Outer loop: controls number of passes
            for (int j = 0; j < n - i - 1; j++) { // Inner loop: compares neighbors
                if (arr[j] > arr[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //Chosen advanced sorting algorithm: Quick Sort

    public void advancedSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //O(nlog n) Splits the array into smaller and smaller pieces.
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Sort left partition
            quickSort(arr, pi + 1, high); // Sort right partition
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // The reference point
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than pivot
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Move the pivot to its final correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return the pivot's position
    }


    //Generates a random array of the specified size
    //allows you to test your code against hundreds or thousands of numbers instantly.
    public int[] generateRandomArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(10000);
        }
        return arr;
    }


    //Prints the elements of the array. [cite: 27]
    //By printing the array before and after you run an algorithm, you can visually confirm that the logic worked.
    public void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

