package algorithm.sorting;

public class InsertionSort implements SortStrategy {

    /**
     * Repeatedly remove an element from input data and insert it into the position so that
     * its value is between the previous and the next element.
     * Insertion is the best of simple sorting.
     * For random data this algorithm runs twice as fast as the bubble sort and faster than selection sort.
     * Average and worst O(n^2), space O(1)
     * @param numbers
     */
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; i++) {
            int tmp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j-1] >= tmp) {
                numbers[j] = numbers[j-1];
                j--;
            }
            numbers[j] = tmp;
        }
    }
}
