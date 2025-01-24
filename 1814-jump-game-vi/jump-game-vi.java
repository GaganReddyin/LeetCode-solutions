class Solution {
    
    public int maxResult(int[] nums, int k) {
        
        /* 
            We will use bottom up approach. That will also take O(n*K)
            Will further optimize by using sorted previous k elements for computation. O(n*logk)
        */
                
        int n = nums.length;
        int dp[] = new int[n];
        
        dp[0] = nums[0];  // Base Case for the dp (for 1st pos, only that value can be max)
        
        // Create Priority Queue which have smaller values first
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int a[], int b[]) -> b[0] - a[0]); 
        pq.add(new int[]{nums[0], 0});
        
        /*
            We have stored below values in Priority Queue
            - arr[0] (value)
            - arr[1] (index)        

            Every time a new arr[] is entered in Priority queue,

            - Comparison is made based on 0th index arr[0]  (which is the value)
              Thus, element with less value is stored ahead in queue

            - During fetching, we check if its 1st index arr[1] (which is the index of value) < i-k
              Thus, the index of fetched value will be in range of [i] and [i-k]
        */
        
        
        for (int i=1; i<n; i++) {
            
            // Check if the peeked value is in range of last k values, use it. Otherwise, remove it.
            
            while (!pq.isEmpty() && pq.peek()[1] < i-k) {
                pq.remove();  // remove till we get index between last k values.
            }
            
            // Set dp[i] = Curr. Value + Max (last k index values)
            dp[i] = nums[i] + pq.peek()[0];
            
            // Add curr index and its value for further dp[i+1] ...  calculations
            pq.add(new int[]{dp[i], i});
            
        }
        
         return dp[n-1];
    }
}