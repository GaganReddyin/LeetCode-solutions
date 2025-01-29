class Solution {
    public TreeNode insertIntoMaxTree(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (current.val < value) {
            TreeNode newRoot = new TreeNode(value);
            newRoot.left = current;
            return newRoot;
        }

        current.right = insertIntoMaxTree(current.right, value);
        return current;
    }
}