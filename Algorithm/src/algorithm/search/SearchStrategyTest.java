package algorithm.search;

public class SearchStrategyTest {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5, 8};

        SearchContext context = new SearchContext(new BinarySearch());
        System.out.print(context.search(numbers, 5));
    }
}
