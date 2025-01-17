class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] sweep = new int[n + 1];  // Step 1: Create sweep array
        
        // Step 2: Update sweep array based on bookings
        for (int i = 0; i < bookings.length; i++) {
            sweep[bookings[i][0] - 1] += bookings[i][2];
            sweep[bookings[i][1]] -= bookings[i][2];
        }
        
        // Step 3: Calculate cumulative sum
        int[] answer = new int[n];
        answer[0] = sweep[0];
        for (int i = 1; i < n; i++) {
            answer[i] = sweep[i] + answer[i - 1];
        }
        
        return answer;  // Step 4: Return final result
    }
}