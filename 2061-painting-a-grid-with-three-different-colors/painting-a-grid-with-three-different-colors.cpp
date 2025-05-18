class Solution {
    static constexpr long long MOD = 1000000007LL;

public:
    int colorTheGrid(int m, int n) {
        vector<vector<int>> states;
        vector<int> col(m, 0);
        enumerateStates(0, m, col, states);

        const int S = static_cast<int>(states.size());
        vector<vector<int>> next(S);
        for (int i = 0; i < S; ++i) 
        {
            for (int j = 0; j < S; ++j) 
            {
                if (compatible(states[i], states[j])) 
                {
                    next[i].push_back(j);
                }
            }
        }

        vector<long long> dp(S, 1);
        vector<long long> ndp(S, 0);

        for (int c = 1; c < n; ++c)
        {
            fill(ndp.begin(), ndp.end(), 0);
            for (int i = 0; i < S; ++i) 
            {
                if (!dp[i]) 
                    continue;
                for (int j : next[i]) 
                {
                    ndp[j] += dp[i];
                    if (ndp[j] >= MOD) 
                        ndp[j] -= MOD;
                }
            }
            dp.swap(ndp);
        }

        long long ans = 0;
        for (long long v : dp) 
        {
            ans += v;
        }
        return static_cast<int>(ans % MOD);
    }

private:
    static void enumerateStates(int r, int m, vector<int>& col, vector<vector<int>>& states) 
    {
        if (r == m) 
        {
            states.push_back(col);
            return;
        }
        for (int clr = 0; clr < 3; ++clr) 
        {
            if (r > 0 && clr == col[r - 1]) 
                continue;
            col[r] = clr;
            enumerateStates(r + 1, m, col, states);
        }
    }
    static bool compatible(const vector<int>& a, const vector<int>& b) 
    {
        for (size_t r = 0; r < a.size(); ++r)
            if (a[r] == b[r]) 
                return false;
        return true;
    }
};