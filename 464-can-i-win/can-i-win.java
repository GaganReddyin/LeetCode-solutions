class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal)    return false;
        return canWin(0, desiredTotal, maxChoosableInteger,  new HashMap<Integer, Boolean>());
    }
    
    private boolean canWin(int state, int total, int max,  Map<Integer, Boolean> dp){
        if(dp.containsKey(state))   return dp.get(state);
        
        for(int i=max;i>=1;i--){
            if( (state&(1<<i))==0 && (total-i<=0 || !canWin(state|(1<<i), total-i, max,  dp))){
                return dp.computeIfAbsent(state, k->true);
            }
        }
        return dp.computeIfAbsent(state, k->false);
    }
}