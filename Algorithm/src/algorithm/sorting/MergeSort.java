package algorithm.sorting;

public class MergeSort implements SortStrategy {

    /**
     * Merge sort divides the array in half recursively until single item.
     * Then merge two sorted arrays until all elements are sorted.
     *
     * It merges two sorted arrays by using the merge method.
     * The merge method is to compare each element in two sorted array one by one,
     * put the smaller one in the third array until one of arrays reaches the end.
     * Then copy the rest of unfinished array to the third array.
     * This requires an additional array in memory, equal in size to the one being sorted.
     *
     * Time O(n*logn), Space O(n), n is array length
     * @param numbers
     */
    @Override
    public void sort(int[] numbers) {
        mergeSortRecursive(numbers, 0, numbers.length - 1);
    }

    private void mergeSortRecursive(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low)/2;
        mergeSortRecursive(numbers, low, mid);
        mergeSortRecursive(numbers, mid + 1, high);
        merge(numbers, low, high);
    }

    private void merge(int[] numbers, int low, int high) {
        int mid = low + (high - low)/2;
        int i = low;     // start of left
        int j = mid + 1; // start of right
        int sub[] = new int[high - low + 1];
        int k = 0;

        while (i <= mid && j <= high) {
            if (numbers[i] <= numbers[j]) {
                sub[k++] = numbers[i++];
            } else {
                sub[k++] = numbers[j++];
            }
        }

        while (i <= mid) {
            sub[k++] = numbers[i++];
        }

        while (j <= high) {
            sub[k++] = numbers[j++];
        }

        i = low;
        for (int r = 0; r < sub.length; r++) {
            numbers[i++] = sub[r];
        }
    }
}
