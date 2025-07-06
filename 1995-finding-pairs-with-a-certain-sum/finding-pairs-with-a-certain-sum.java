class FindSumPairs {
    HashMap<Integer, Integer> map1;
    HashMap<Integer, Integer> map2;
    int[] arr;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        arr = new int[nums2.length];
        for(int i = 0; i < nums1.length; i++)
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        for(int i = 0; i < nums2.length; i++)
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        arr = nums2;
    }
    
    public void add(int index, int val) {
        map2.put(arr[index], map2.get(arr[index]) - 1);
        arr[index] += val;
        map2.put(arr[index], map2.getOrDefault(arr[index], 0) + 1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for(int key : map1.keySet()) {
        	int tar = tot - key;
        	ans += map1.get(key) * map2.getOrDefault(tar, 0);
        }
        return ans;
    }
}