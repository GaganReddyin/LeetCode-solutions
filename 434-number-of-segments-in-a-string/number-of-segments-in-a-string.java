class Solution {
    public int countSegments(String s) {
        char prev=' ';
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && prev==' ' ) count++;
            prev= s.charAt(i);
        }

        return count;
    }
}