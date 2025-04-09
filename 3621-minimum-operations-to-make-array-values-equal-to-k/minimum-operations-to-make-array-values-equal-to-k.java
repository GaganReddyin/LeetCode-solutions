class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> storage = new HashSet<>();
        

        for(int num: nums){
            if(num<k){
                return -1;
            }
            else if(num>k){
                storage.add(num);
            }
        }

        return storage.size(); 
    }
}