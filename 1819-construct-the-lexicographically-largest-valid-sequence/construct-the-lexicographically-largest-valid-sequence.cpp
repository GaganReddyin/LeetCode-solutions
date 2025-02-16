class Solution {
public:

    void backTracking(int i, int k, int n, vector<int>&ans, vector<int>&comb, vector<int>&count){

        if(!ans.size() && k<=comb.size()){
            if(i == n+1){
                ans = comb;
            }
            else if(comb[k]){
                backTracking(i, k+1, n, ans, comb, count);
            }

            else{
                int j;
                for(j = n; j>0; j--){
                    if(!count[j] && (( k+j< comb.size() && !comb[k+j]) || j == 1)){
                        comb[k] = j;
                        if(j!=1){
                            comb[k+j] = j;
                        }
                        count[j]+=2;
                        backTracking(i+1, k+1, n, ans, comb, count);
                        comb[k] = 0;
                        if(j!=1){
                            comb[k+j] = 0;
                        }
                        count[j]-=2;   
                    }
                }
            }
        }
    }

    vector<int> constructDistancedSequence(int n) {
        
        vector<int>count(n+1);
        vector<int>ans;
        vector<int>comb(n*2-1);
        backTracking(1, 0, n, ans, comb, count);
        return ans;
    }
};