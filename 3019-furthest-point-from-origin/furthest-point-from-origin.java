class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lcount = 0, rcount =0, uscore = 0;
        for(char i:moves.toCharArray()){
            if(i == 'L'){
                lcount++;
            } else if(i == 'R'){
                rcount++;
            } else{
                uscore++;
            }
        }
        return Math.abs(lcount - rcount) + uscore;
        
    }
}