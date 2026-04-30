import java.util.Arrays;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long startTime = System.nanoTime(); // UIt’s like using a stopwatch that can measure billionths of a second.
        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }
        return System.nanoTime() - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime(); // Measure searching execution [cite: 37]
        searcher.search(arr, target);
        return System.nanoTime() - startTime;
    }

    public void runAllExperiments() {
        // Testing Small (10), Medium (100), and Large (1000+) [cite: 56, 57, 58]
        // tests the algorithms against different "stress levels" by increasing the size of the arrays.
        int[] sizes = {10, 100, 1000, 5000};

        for (int size : sizes) {
            System.out.println("Experiment Size: " + size);

            // 1. TEST WITH RANDOM DATA [cite: 60, 77]
            int[] randomData = sorter.generateRandomArray(size);
            runTests(randomData, "Random");

            // 2. TEST WITH SORTED DATA [cite: 63, 77]
            // We reuse the sorted version to see how the algorithms react [cite: 81]
            int[] sortedData = randomData.clone();
            //The code doesn't just test random numbers; it tests how the algorithms behave when the data is already sorted.
            Arrays.sort(sortedData);
            runTests(sortedData, "Sorted");

            System.out.println();
        }
    }

    private void runTests(int[] data, String dataType) {
        System.out.println("Data Type: " + dataType);

        // Basic Sort (Bubble Sort) [cite: 65]
        int[] basicCopy = data.clone();
        long bTime = measureSortTime(basicCopy, "basic");
        //To make sure the tests are fair, this method uses .clone() to give each algorithm an identical copy of the data.
        System.out.println("Basic Sort: " + bTime + " ns");

        // Advanced Sort (Quick Sort) [cite: 69]
        int[] advCopy = data.clone();
        long aTime = measureSortTime(advCopy, "advanced");
        System.out.println("Advanced Sort: " + aTime + " ns");

        // Search (Binary Search) [cite: 68]
        // Note: For Binary Search to work, we use the sorted advCopy
        long sTime = measureSearchTime(advCopy, advCopy[advCopy.length / 2]);
        System.out.println("Search Time: " + sTime + " ns");
    }
}
