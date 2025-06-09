class Solution {
public:

    int solve(int n, long curr, long second) {
        int cnt = 0;
        while (curr <= n) {
            cnt += min((long long)(n + 1), (long long)second) - curr;
            curr *= 10;
            second *= 10;
        }
        return cnt;
    }

    int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int cnt = solve(n, curr, curr + 1);
            if (cnt <= k) {
                curr++;
                k -= cnt;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
};