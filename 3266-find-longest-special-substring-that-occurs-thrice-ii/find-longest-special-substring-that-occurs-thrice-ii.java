class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int ans[][]=new int[26][n+1];
        for(int i=0;i<n;){
            char cur=s.charAt(i);
            int j=i;
            while(j<n&&s.charAt(j)==cur){
                j++;
                ans[cur-'a'][j-i]+=1;
            }
            i=j;
        }
        int an=-1;
        for(int i=0;i<26;i++){
            int freq=0;
            for(int j=n;j>-1;j--){
                freq+=ans[i][j];
                if(freq>=3){

                    an=Math.max(an,j);
                }
            }
        }
        return an;
        
    }
}