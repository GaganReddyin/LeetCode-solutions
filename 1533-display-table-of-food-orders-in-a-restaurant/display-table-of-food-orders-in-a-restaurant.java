class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Long, Map<String, Long>> orderMap = orders.stream()
            .collect(Collectors.groupingBy(
                    x -> Long.parseLong(x.get(1)), // First-level key (table number)
                    TreeMap::new, // Ensure ordered keys (table numbers)
                    Collectors.groupingBy(
                            x -> x.get(2), // Second-level key (food item)
                            Collectors.counting() // Count occurrences
                    )
            ));

    // Prepare the header (first row), adding "Table" and all food items
    List<String> headerList = new ArrayList<>();
    headerList.add("Table");

    // Collect second-level keys (food items) while maintaining order using LinkedHashSet
    Set<String> foodItems = orderMap.values().stream()
            .flatMap(innerMap -> innerMap.keySet().stream())
            .collect(Collectors.toCollection(TreeSet::new)); // Maintain insertion order

    headerList.addAll(foodItems); // Add food items to the header list
    List<List<String>> resultList = new ArrayList<>();
    resultList.add(headerList); // Add header to result list

    // Convert orderMap to list of lists for each table
    for (Map.Entry<Long, Map<String, Long>> outerEntry : orderMap.entrySet()) {
        List<String> row = new ArrayList<>();
        row.add(outerEntry.getKey().toString()); // Add table number

        // Add counts for each food item in the order of the header
        foodItems.forEach(foodItem -> {
            row.add(outerEntry.getValue().getOrDefault(foodItem, 0L).toString()); // Default to 0 if not present
        });

        resultList.add(row); // Add the row to the result list
    }

    return resultList; // Return the final result
    }
}