class Solution {
    public int maximum69Number (int num) {
       String temp=String.valueOf(num);
       char c[]=temp.toCharArray();
       
       int i=0;
       while(i<c.length){
        if(c[i]=='6'){
            c[i]='9';
            break;
        }
        i++;
       }
       String c1=new String(c);
   return Integer.parseInt(c1);
   }
}