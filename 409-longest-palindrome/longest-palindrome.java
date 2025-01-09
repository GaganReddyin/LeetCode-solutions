class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[100];
        int result = 0;
        int flag = 0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'A']++;
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i) - 'A'] % 2 == 0){
                result += arr[s.charAt(i) - 'A'];
                arr[s.charAt(i) - 'A'] = 0;
            }
            else if(arr[s.charAt(i) - 'A'] != 0){
                flag = 1;
                result += arr[s.charAt(i) - 'A'] - 1;
                arr[s.charAt(i) - 'A'] = 0;
            }
        }
        if(flag == 1)
        return result = result+1;
        else
        return result;
    }
}