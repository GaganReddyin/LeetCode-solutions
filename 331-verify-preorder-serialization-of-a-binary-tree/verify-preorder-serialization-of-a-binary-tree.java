class Solution {
    public boolean isValidSerialization(String s) {
        int node=0;
        String[] ar = s.split(",");
        int n=ar.length;
        
        int i=0;
        if(n==0)
            return true;
        if(ar[0].charAt(0)!='#')
            node=2;
        i=1;
        while(i<n){
            if(node==0)
                return false;
            
            if(ar[i].charAt(0)!='#'){
                node++;
            }else{
                node--;
            }
            i++;
        }
        if(node==0)
            return true;
        else
            return false;
    }
}