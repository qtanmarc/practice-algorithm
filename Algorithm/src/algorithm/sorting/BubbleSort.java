package algorithm.sorting;

public class BubbleSort implements SortStrategy {

    /**
     * Compare adjacent elements and swap them if they are in the wrong order.
     * Smaller or larger elements bubble to the top of the list.
     * Time worst and average O(n^2), Space O(1)
     * @param numbers
     */
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    swap(numbers, j, j+1);
                }
            }
        }
    }

    /**
     * Use flag to skip the remaining passes.
     * Time worst O(n^2), Best O(n), space O(1)
     * @param numbers
     */
    public void sortBetter(int[] numbers) {
        boolean swapped = true;
        int last = numbers.length - 1;
        while(swapped) {
            swapped = false;

            for(int i = 0; i < last; i++) {
                if (numbers[i] > numbers[i+1]) {
                    swap(numbers, i, i+1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
