package algorithm.sorting;

public class SortStrategyTest {

    public static void main(String[] args) {
        int[] numbers = {3, 2, 8, 1, 5};

        SortContext context = new SortContext(new QuickSort());
        context.arrange(numbers);

        System.out.println("------- Quicksort -------");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }
}
