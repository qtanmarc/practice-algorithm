package algorithm.search;

public class BinarySearch implements SearchStrategy {

    /**
     * Binary search is an efficient algorithm for finding an item from an ordered list of items.
     * It works by dividing in half the portion of the list, until narrowing down the possible locations
     * to just one.
     * Time O(logn), Space O(1)
     * @param arr
     * @param key
     * @return
     */
    @Override
    public int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
