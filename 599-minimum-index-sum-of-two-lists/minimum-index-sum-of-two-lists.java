class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int sum = map1.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    list.clear();
                    list.add(list2[i]);
                } else if (sum == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(String[]::new);
    }
}