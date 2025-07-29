class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int arr[]= new int[34];
        int or[]= new int[nums.length];
        int ans[]= new int[nums.length];
        int x=0;
        if(nums.length==1)
        {
            ans[0]=1;
            return ans;
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            x=x|nums[i];
            or[i]=x;

        }
        int j=0;
        int temp=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==or[i])
            {
                ans[i]=1;
                j++;
                continue;
            }
            while(j<nums.length&&(temp)!=or[i])
            {
                temp=temp|nums[j];
                addor(arr,nums[j]);
                j++;
            }
            ans[i]=j-i;
            removeor(arr,nums[i]);
            temp=calor(arr);
        }
        return ans;
    }
    public void addor(int[] arr, int n)
    {
        int count=0;
        while(n!=0)
        {
            arr[count]+=n&1;
            n=n>>1;
            count++;
        }
    }
    public void removeor(int[] arr, int n)
    {
        int count=0;
        while(n!=0)
        {
            arr[count]-=n&1;
            n=n>>1;
            count++;
        }
    }
    public int calor(int[] arr)
    {
        int x=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                x=x|(int)(Math.pow(2,i));
            }
        }
        return x;
    }
}