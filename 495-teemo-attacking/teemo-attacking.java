class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int size = timeSeries.length;
        int out = duration;
        for (int i = 1; i < size; i++) {
            out += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return out;
    }
}