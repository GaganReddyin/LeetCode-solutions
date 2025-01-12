
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length()); // Sort by length (descending)
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            boolean isUncommon = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) { // Check if it's a subsequence of any other string
                    isUncommon = false;
                    break;
                }
            }
            if (isUncommon) {
                return strs[i].length(); // Found the longest uncommon subsequence
            }
        }

        return -1; // No uncommon subsequence found
    }

    // Helper function to check if a is a subsequence of b
    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}