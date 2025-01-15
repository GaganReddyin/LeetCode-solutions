class Solution {
    public int minMoves(int[] nums) {
       // After m moves we get all numbers to x
       // total sum before op = tsum
       // sum after m moves= n*x;
       // in each operation sum increment by n-1 so after m operation it will increment by m*(n-1)
       // tsum+m*(n-1) = n*x;
       // After m moves, minimun element in array will be equal to x; so x =minElement+m;
       // tsum+mn-m=n*(minElement+m)
       // tsum+mn-m=n*minElement+n*m;
       //tsum-m=n*minElement
       //m= tsum-n*minElement
       int totalSum=0;
       int min=Integer.MAX_VALUE;
       for(int num:nums){
        min=Math.min(min,num);
        totalSum+=num;
       }
       int n=nums.length;
       return totalSum-n*min;
    }
}