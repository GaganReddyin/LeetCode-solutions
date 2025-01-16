class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=0;
        int n2=0;
        if(nums1.length%2!=0){
            for(int i=0; i<nums2.length; i++){
                n1=n1^nums2[i];
            }
        }
        if(nums2.length%2!=0){
            for(int i=0; i<nums1.length; i++){
                n2=n2^nums1[i];
            }
        }
        return n1^n2;
    }
}