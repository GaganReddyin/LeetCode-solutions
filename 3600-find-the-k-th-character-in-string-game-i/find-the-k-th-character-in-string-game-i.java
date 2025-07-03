class Solution {
    String str="a";
    public char kthCharacter(int k) {
        int n=str.length();
        if(n>=k)
        {
            return str.charAt(k-1);
        }
        // String new_str="";
        for(int i=0;i<n;i++)
        {
            str+=(char)(str.charAt(i)+1);
        }
        // str+=new_str;
        return kthCharacter(k);
    }
}