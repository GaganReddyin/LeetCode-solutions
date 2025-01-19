class Solution {
    int cons;
    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        cons = root.val;
        helper(root);
        return flag;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        if(cons != root.val){
            flag = false;
        }
        if(flag){
            helper(root.left);
            helper(root.right);
        }
    }
}