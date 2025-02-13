class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long long, vector<long long>, greater<long long>> minHeap(nums.begin(), nums.end());
        int ans = 0;
        
        while (minHeap.top() < k) {
            if (minHeap.size() < 2) return -1; // Impossible to proceed

            long long num1 = minHeap.top(); minHeap.pop();
            long long num2 = minHeap.top(); minHeap.pop();
            
            long long newValue = 2 * num1 + num2;  // Prevent overflow
            minHeap.push(newValue);
            ans++; }
        
        return ans;}};