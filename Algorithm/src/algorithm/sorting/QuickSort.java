package algorithm.sorting;

public class QuickSort implements SortStrategy {

    /**
     * Quicksort partitions the array into two sub arrays by calling a partition method.
     * In this method, a pivot is the key value to determine when to swap unordered elements.
     * It returns the index of the partition.
     * Then the sorting method calls itself to sort these two sub arrays.
     *
     * In the partition method, there are different ways to define pivot.
     * For example, it can be the first, last or the middle item in the sub array.
     * In this solution, the pivot is the middle of the array. The formula of its index is mid=low+(high-low)/2.
     * Meanwhile in the partition method, there are two pointers, low points to the first element. high points to the last element.
     * Increase the low pointer if the values it points are less than the pivot.
     * Decrease the high pointer if the values are larger than the pivot.
     * After moving the pointers, if the low pointer is still less equal than the high pointer,
     * swap the elements in the array.
     * After each partition, either the largest element swaps to the right, or the smallest element swaps to the left.
     * Quicksort uses divide and conquer technique as merge sort. It operates in O(nlogn) time. It is faster than simple sorting such as bubble sort, selection sort and insertion sort.
     * @param numbers
     */
    @Override
    public void sort(int[] numbers) {
        quickSortRecursive(numbers, 0, numbers.length - 1);
    }

    private void quickSortRecursive(int[] numbers, int low, int high) {
        int index = partition(numbers, low, high);

        if (low < index - 1) {
            quickSortRecursive(numbers, low, index - 1);
        }

        if (index < high) {
            quickSortRecursive(numbers, index, high);
        }
    }

    private int partition(int[] numbers, int low, int high) {
        int mid = low + (high - low)/2;
        int pivot = numbers[mid];

        while (low <= high) {
            while(numbers[low] < pivot) {
                low++;
            }

            while (numbers[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swap(numbers, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
