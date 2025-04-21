class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefix = 0;
        long min = 0, max = 0;
        
        for (int diff : differences) {
            prefix += diff;
            min = Math.min(min, prefix);
            max = Math.max(max, prefix);
        }
        
        long range = (upper - lower) - (max - min) + 1;
        return (int)Math.max(0, range);
    }
}