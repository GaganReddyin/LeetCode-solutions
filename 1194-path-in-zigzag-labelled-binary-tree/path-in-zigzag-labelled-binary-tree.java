class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        ans.add(label);
        int xx = (int)(Math.log(label)/Math.log(2));
        for(int i=0;i<xx;i++)
        {
            int x = (int)Math.pow(2,(int)(Math.log((int)label/2)/Math.log(2))+1)-1;
            label = x - (int)label/2 + (x+1)/2 ;
            ans.add(0,label);
        }
        
        return ans;
        
    }
}