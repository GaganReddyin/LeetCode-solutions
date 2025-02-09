class Solution {
public:
    typedef long long ll;
    long long countBadPairs(vector<int>& v) {
        unordered_map<int,int> mp;
        ll tot=0,ans=0,n=v.size();
        for(int i=0;i<n;i++){
            ans+=tot;
            ans-=mp[v[i]-i];
            mp[v[i]-i]++;
            tot++;
        }
        return ans;
    }
};