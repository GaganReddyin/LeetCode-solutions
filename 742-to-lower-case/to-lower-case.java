class Solution {
    public String toLowerCase(String s) {                              
        for(int i=0;i<=s.length()/2;i++)
        {
            if(s.charAt(i)+0>=65&&s.charAt(i)+0<=90)
            {
                s+=(char)(s.charAt(i)+32);
            }
            else
            {
                s+=s.charAt(i);
            }            
        }                        
        return s.substring(s.length()/2,s.length()-1);
    }
}