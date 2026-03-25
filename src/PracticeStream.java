import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeStream {

    public static void main(String[] args) {
        convertToUppercase();
        filterEvenNumbers();
        sumOfAllElements();
        countNumberOfStrings();
    }

    private static void convertToUppercase() {
        List<String> input = Arrays.asList("java", "stream", "api");
        List<String> result = input.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void sumOfAllElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum = " + sum);
    }

    private static void countNumberOfStrings() {
        List<String> input = Arrays.asList("java", "stream", "api");
        long count = input.stream()
                .filter(s -> s.length() > 3)
                .count();
        System.out.println("count = " + count);
    }
}
