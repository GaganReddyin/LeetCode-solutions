class Solution {
    int prev=Integer.MIN_VALUE, freq=0, maxf=1; List<Integer> lis=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        return lis.stream().mapToInt(i -> i).toArray();
    }
    private void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(prev==root.val) freq++;
        else {
            freq=1;
            prev=root.val;
        }

        if(freq==maxf) {
            lis.add(root.val);
        }else if(freq>maxf) {
            maxf=freq;
            lis=new ArrayList<>();
            lis.add(root.val);
        }
        inorder(root.right);
    }
}