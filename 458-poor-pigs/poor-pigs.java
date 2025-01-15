class Solution {
    // Method to calculate the minimum number of pigs needed to find the poisonous bucket 
    // within the given testing time limit.
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Calculate the 'base' which is the number of states a pig can be in. It's a reflection of
        // how many times you can test each pig within the total testing time 'minutesToTest'.
        int base = minutesToTest / minutesToDie + 1;

        // Initialize a counter for the number of pigs needed.
        int numberOfPigs = 0;

        // Loop to calculate the number of pigs needed. The idea is to multiply the base by itself 
        // until we reach or exceed the number of buckets.
        for (int currentBuckets = 1; currentBuckets < buckets; currentBuckets *= base) {
            // Each time we are able to cover more buckets with current number of pigs, we increase the pig count.
            numberOfPigs++;
        }

        // Return the number of pigs calculated as the result.
        return numberOfPigs;
    }
}