class Solution {
    public int minimumLength(String s) {
        /* 
            TC - O(len(s))
            SC - O(1)

            1. COUNT CHARACTER FREQUENCY
            2. IF CHARACTER FREQUENCY IS
                A. EVEN -> THERE WILL BE 2 CHARACTERS REMAINING AT THE END
                B. ODD -> ONE CHARACTER WILL BE REMAINING AT THE END
                C. ADD THIS TO RESULT
            3. RETURN RESULT
        */
        int[] charFreq = new int[26];
        
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        
        int res = 0;
        for (int freq : charFreq) {
            if (freq > 0) {
                res += 1 + ((freq % 2 == 0) ? 1 : 0);
            }
        }
        
        return res;
    }
}