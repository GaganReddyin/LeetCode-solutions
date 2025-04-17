class Solution {
	public  static int countPairs(int[] arr, int k) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((arr[i] == arr[j]) && ((i * j) % k == 0)) {
					count++;
				}
			}
		}
		return count;
	}
}