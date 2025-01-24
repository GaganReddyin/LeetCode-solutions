class Solution {
    public String sortString(String s) {
        
        //Declaring the result String
        StringBuilder result=new StringBuilder("");
        
        //taking counter letterCount for iterating over the loop
        int letterCount=s.length();
        
        //Counting the frequency of the letters  using array;
        int letterFrequency[]=new int[26];
        Arrays.fill(letterFrequency,0);
        for(int i=0;i<s.length();i++){letterFrequency[s.charAt(i)-'a']++;}
        
        //iterating the loop for numberOfLetters present in the String
        while(letterCount>0){
            
            //iterating for the steps 1-2-3 i.e taking the string for the last 
            for(int i=0;i<letterFrequency.length;i++){
                
                if(letterFrequency[i]!=0){
                    result.append((char)(i+97));
                    letterFrequency[i]--;
                    letterCount--;
                }
            }
            
            //iterating for the step 4-5-6 i.e taking the string from the last
            for(int i=letterFrequency.length-1;i>=0;i--){
                if(letterFrequency[i]!=0){
                    result.append((char)(i+97));
                    letterFrequency[i]--;
                    letterCount--;
                }
            }
        }
        
        //converting the StringBuilder to String Using toString() function
        return result.toString();
    }
}