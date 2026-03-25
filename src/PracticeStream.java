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
    findFrequency();
    getFirst3();

    /**
     * custom Object sorting
     */
    customObjectSorting();

    /**
     * Multi-level grouping
     */
    multiLevelGrouping();
}

private static void customObjectSorting() {
    final Employee employee1 = new Employee("Raza", 20, "IT");
    final Employee employee2 = new Employee("Waseem", 30, "Sales");
    final Employee employee3 = new Employee("Mohammad", 50, "IT");
    final List<Employee> employees = List.of(employee1, employee2, employee3);

    employees.forEach(x -> System.out.println(x.getName() + ":" + x.getAge()));
    final List<Employee> sorted = employees.stream()
            .sorted(Comparator.comparing(Employee::getAge).reversed())
            .toList();

    sorted.forEach(x -> System.out.println(x.getName() + ":" + x.getAge()));
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

private static void findFrequency() {
    List<Integer> numbers = Arrays.asList(6, 5, 6, 2, 5, 3, 12, 1);
    Map<Integer, Long> freq = numbers.stream()
            .collect(Collectors.groupingBy(
                    n -> n,
                    Collectors.counting()
            ));
    IO.println("Frequency: " + freq);
}

private static void getFirst3() {
    List<Integer> numbers = Arrays.asList(6, 5, 2, 3, 12, 1);
    IO.println("Initial List: " + numbers);
    List<Integer> top3 = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .toList();
    IO.println("Top 3: " + top3);
}

private static void multiLevelGrouping() {
    final Employee employee1 = new Employee("Raza", 20, "IT");
    final Employee employee2 = new Employee("Waseem", 30, "Sales");
    final Employee employee3 = new Employee("Peter", 30, "Sales");
    final Employee employee4 = new Employee("Mohammad", 50, "IT");
    final List<Employee> employees = List.of(employee1, employee2, employee3, employee4);

    Map<String, Map<Integer, List<Employee>>> result =
            employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.groupingBy(Employee::getAge)
                    ));

    result.forEach((key, value) -> {
        IO.println(key);
        value.forEach((k, v) ->
                IO.println(k + " " +
                        v.stream()
                                .map(Employee::getName)
                                .toList()
                )
        );
    });
}