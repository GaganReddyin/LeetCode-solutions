class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    Random r = new Random();
    int valid;
    public Solution(int n, int[] blacklist) {
        for(int i =0;i<blacklist.length;i++){
            map.put(blacklist[i],-1);
        }
        valid = n-blacklist.length;
    //we are using n-1 because random in range(0,n) always eexcludes n
        for(int i=0;i<blacklist.length;i++){
            if(blacklist[i]<valid){
                while(map.containsKey(n-1)==true) n--;
                map.put(blacklist[i],n-1);
                n--;
            }
        }
    }
    
    public int pick() {
        int val = r.nextInt(valid);
        if(map.containsKey(val)){
            val = map.get(val);
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */