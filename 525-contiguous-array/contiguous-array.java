class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int max_len=0;
        int n=nums.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=(nums[i]==0)?-1:1;
            if(map.containsKey(sum)){
                int len=i-map.get(sum);
                max_len=Math.max(max_len,len);
            }
            else{
                map.put(sum,i);
            }
        }

        return max_len;
    }
}