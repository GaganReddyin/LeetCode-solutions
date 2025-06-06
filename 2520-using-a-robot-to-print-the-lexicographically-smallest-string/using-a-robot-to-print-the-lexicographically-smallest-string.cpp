class Solution {
public:
    string robotWithString(string s) {
        stack<char> st;
        int start=0;
        int n=s.length();
        vector<char> small(n);
        char ch=CHAR_MAX;
        string ans="";
        for(int i=n-1;i>=0;i--){
            ch=min(ch,s[i]);
            small[i]=ch;
        }
        for(int i=0;i<n;i++){
            while(!st.empty() && small[i]>=st.top()){
                ans+=st.top();
                st.pop();
            }
            if(small[i]==s[i]){
                ans+=s[i];
                if(start<i){
                    for(int k=start;k<i;k++){
                        st.push(s[k]);
                    }
                }
                start=i+1;
            }
        }
        while(!st.empty()){
            ans+=st.top();
            st.pop();
        }
        return ans;
        
    }
};