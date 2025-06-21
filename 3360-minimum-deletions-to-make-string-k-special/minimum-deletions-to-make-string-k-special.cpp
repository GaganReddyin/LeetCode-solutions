class Solution {
private:
    int dp[26][26];
    int f(vector<int>&freq, int l, int r, int k){
        if(l==r)return 0;
        if(freq[r]-freq[l]<=k)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        
        return dp[l][r]=min(freq[l]+f(freq,l+1,r,k), freq[r]-(freq[l]+k)+f(freq,l,r-1,k));
    }
public:
    int minimumDeletions(string word, int k) {
        vector<int>freq(26,0);
        for(int i=0; i<word.size(); i++){
            freq[word[i]-'a']++;
        }
        sort(freq.begin(),freq.end());
        memset(dp,-1,sizeof(dp));
        return f(freq,0,25,k);
    }
};