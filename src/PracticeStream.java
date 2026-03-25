void main() {
    convertToUppercase();
    filterEvenNumbers();
    sumOfAllElements();
    countNumberOfStrings();
    sortList();
    findFirst();
    findMax();
    removeDuplicate();
}

private static void removeDuplicate() {
    List<Integer> numbers = Arrays.asList(6, 5, 6, 2, 5, 3, 12, 1);
    IO.println("With duplicate " + numbers);
    List<Integer> distinct = numbers.stream()
            .distinct()
            .toList();
    IO.println("Without duplicate: " + distinct);
}

private static void sortList() {
    List<Integer> numbers = Arrays.asList(6, 5, 4, 2, 3, 12, 1);
    IO.println("Actual array: " + numbers);

    List<Integer> sorted = numbers.stream()
            .sorted()
            .toList();
    IO.println("Sorted: " + sorted);

}

private static void findFirst() {
    List<Integer> numbers = Arrays.asList(6, 5, 4, 2, 3, 12, 1);
    Optional<Integer> first = numbers.stream()
            .findFirst();
    IO.println("First element: " + first);
}

private static void findMax() {
    List<Integer> numbers = Arrays.asList(6, 5, 4, 2, 3, 12, 1);
    Optional<Integer> max = numbers.stream()
            .max(Integer::compareTo);
    IO.println("Max element: " + max);
}

private static void convertToUppercase() {
    List<String> input = Arrays.asList("java", "stream", "api");
    List<String> result = input.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    IO.println(result);
}

private static void filterEvenNumbers() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> result = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
    IO.println(result);
}

private static void sumOfAllElements() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int sum = numbers.stream()
            .mapToInt(n -> n)
            .sum();
    IO.println("sum = " + sum);
}

private static void countNumberOfStrings() {
    List<String> input = Arrays.asList("java", "stream", "api");
    long count = input.stream()
            .filter(s -> s.length() > 3)
            .count();
    IO.println("count = " + count);
}
