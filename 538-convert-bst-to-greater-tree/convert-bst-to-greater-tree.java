class Solution {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int rightSum = 0;
        while(node !=null || !stack.isEmpty()) {
            while(node !=null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += rightSum; 
            rightSum =node.val;
            node = node.left;           
        }
        return root;       
        
    }    

}