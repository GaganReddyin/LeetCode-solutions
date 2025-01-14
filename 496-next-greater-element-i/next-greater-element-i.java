class Solution {
    public int[] nextGreaterElement(int[] a1, int[] a2) {
        int ans[]=new int[a1.length];
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<a2.length;i++){
            while(!s.isEmpty() && s.peek()<a2[i]){
                int val=s.pop();
                map.put(val,a2[i]);
            }
            s.push(a2[i]);
        }
        for(int i=0;i<a1.length;i++){
            ans[i]=map.getOrDefault(a1[i],-1);
        }
        return ans;
    }
}