class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int len = word.length();
        for(int i = k; i < len; i += k){
            String s = word.substring(i);
            int q = s.length();
            boolean good = true;
            for(int j = 0; j < q; j++){
                if(s.charAt(j) != word.charAt(j)) good = false;
            }
            if(good) return i / k;
        }
        return (len + k - 1) / k;
    }
}