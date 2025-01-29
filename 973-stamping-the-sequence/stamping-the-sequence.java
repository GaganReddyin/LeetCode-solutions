class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int slen = stamp.length();
        int tlen = target.length();
        
        char ss[] = stamp.toCharArray();
        char tt[] = target.toCharArray();
        int count = 0;
        List<Integer> mList = new ArrayList<>();
        while(count != tlen) {
            int prev = count;
            for(int i = 0; i < tlen-slen+1; i++) {
                if(canReplace(tt, ss, i)){
                    
                    count += modify(tt,ss,i);
                    mList.add(i);
                    if(count == tlen)
                        break;
                }
            }
            if(prev == count)
                return new int[0];
        }
        
        //System.out.println(mList);
        Collections.reverse(mList);
        
        int[] res = new int[mList.size()];
        int arrp = 0;
        
        for(int i : mList) {
            res[arrp++] = i;
        }
        
        return res;
        
    }
    
    public int modify(char tgt[], char stamp[], int pos) {
        int res = 0;
        int len = stamp.length;
        for(int i = 0; i< len; i++) {
            if(tgt[pos+i] != '?'){
               tgt[pos+i] = '?';
                res++; 
            }
        }
        return res;
    }
    
    public boolean canReplace(char tgt[], char stamp[], int pos) {
        
        int len = stamp.length;
        
        for(int i = 0; i< len; i++) {
            if(tgt[pos+i] != '?' && tgt[pos+i] != stamp[i])
                return false;
        }
        
        return true;
        
    }
}