void main() {
    convertToUppercase();
    filterEvenNumbers();
    sumOfAllElements();
    countNumberOfStrings();
    sortList();
    findFirst();
    findMax();
    concatenateStrings();
    removeDuplicate();
    convertListToMap();
    groupByLength();
    flatMap();
    findSecondHighest();
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

private static void convertListToMap() {
    List<String> input = Arrays.asList("java", "stream", "api");
    System.out.println("List: " + input);
    Map<String, Integer> map = input.stream()
            .collect(Collectors.toMap(
                    s -> s, String::length
            ));

    IO.println("List To Map: " + map);
}

private static void groupByLength() {
    List<String> input = Arrays.asList("java", "stream", "api", "Mohammad", "Raza");
    System.out.println("List: " + input);
    Map<Integer, List<String>> collect = input.stream()
            .collect(Collectors.groupingBy(String::length));

    IO.println("Group by length: " + collect);
}

private static void countNumberOfStrings() {
    List<String> input = Arrays.asList("java", "stream", "api");
    long count = input.stream()
            .filter(s -> s.length() > 3)
            .count();
    IO.println("count = " + count);
}

private static void concatenateStrings() {
    List<String> input = Arrays.asList("java", "stream", "api");
    String result = input.stream()
            .collect(Collectors.joining(", "));
    // String result = String.join(", ", input); // without using Stream
    IO.println("Concatenated strings: " + result);
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

private static void flatMap() {
    List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4)
    );
    IO.println("Before flatmap: " + nested);
    List<Integer> flat = nested.stream()
            .flatMap(List::stream)
            .toList();

    IO.println("After flatmap: " + flat);
}

private static void findSecondHighest() {
    List<Integer> numbers = Arrays.asList(5, 6, 2, 3, 12, 1);
    IO.println("Initial List: " + numbers);
    Optional<Integer> secondHighest = numbers.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst();

    IO.println("Second highest: " + secondHighest.orElse(-1));
}