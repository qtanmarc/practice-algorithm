package algorithm.sorting;

public class SortContext {

    private SortStrategy sortStrategy;

    public SortContext(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void arrange(int[] input) {
        sortStrategy.sort(input);
    }
}
