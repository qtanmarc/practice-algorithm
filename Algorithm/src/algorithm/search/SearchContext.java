package algorithm.search;

public class SearchContext {

    private SearchStrategy strategy;

    public SearchContext(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public int search(int[] arr, int key) {
        return this.strategy.search(arr, key);
    }
}
