package algorithm.sorting;

public class SelectionSort implements SortStrategy {

    /**
     * Repeatedly find the minimum element from unsorted path and put it at the beginning.
     * The selection sort minimizes the number of swaps, but the number of comparison is still high.
     * For data that is already sorted or almost sorted, the insertion sort does better.
     * Average and worst O(n^2), Space O(1)
     * @param numbers
     */
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            swap(numbers, i, min);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
