void main() {

    final Employee employee2 = new Employee("Waseem", 30, 2000,"Sales");
    final Employee employee1 = new Employee("Raza", 20, 3000,"IT");
    final Employee employee3 = new Employee("Mohammad", 50, 5000,"IT");
    final List<Employee> employees = List.of(employee1, employee2, employee3);

    createTupleAndCollectToMap(employees);
    createTupleAndSort(employees);
    createTupleAndFilter(employees);

    tupleWithGroupingAndAggregation(employees);
}

private static void createTupleAndFilter(List<Employee> employees) {
    List<Pair<String, Integer>> result = employees.stream()
            .map(e -> new Pair<>(e.getDepartment(), e.getAge()))
            .filter(p -> p.value > 25)
            .toList();
    IO.println("Filtered List:");
    result.forEach(System.out::println);
}

record Pair<K, V> (K key, V value) {}

private static void createTupleAndCollectToMap(final List<Employee> employees) {

    List<Pair<String, String>> pairs = employees.stream()
            .map(e -> new Pair<>(e.getDepartment(), e.getName()))
            .toList();

    Map<String, List<String>> result = pairs.stream()
            .collect(Collectors.groupingBy(
                    p -> p.key,
                    Collectors.mapping(p -> p.value, Collectors.toList())
            ));

    result.forEach((key, value) -> {
        IO.println("Department: " + key);
        IO.println(value);
    });
}

private static void createTupleAndSort(final List<Employee> employees) {
    List<Pair<String, Integer>> result = employees.stream()
            .map(e -> new Pair<>(e.getName(), e.getAge()))
            .sorted(Comparator.comparing(Pair<String, Integer>::value).reversed())
            .toList();

    IO.println("Sorted List:");
    result.forEach(System.out::println);
}

private static void tupleWithGroupingAndAggregation(List<Employee> employees) {
    Map<String, Integer> result = employees.stream()
            .map(e -> new Pair<>(e.getDepartment(), e.getSalary()))
            .collect(Collectors.groupingBy(
                    p -> p.key,
                    Collectors.summingInt(p -> p.value)
            ));

    IO.println("Tuple + Grouping + Aggregation:");
    result.forEach((key, value) -> System.out.println(key + " : " + value));
}