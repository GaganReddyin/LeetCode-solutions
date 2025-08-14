class Solution {
    public String largestGoodInteger(String num) {
        String max="";
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2) && num.charAt(i)==num.charAt(i+2)){
                String n=num.substring(i,i+3);
                if(max=="" || n.compareTo(max)>0){
                    max=n;
                }
            }
        }
        return max;
    }
}