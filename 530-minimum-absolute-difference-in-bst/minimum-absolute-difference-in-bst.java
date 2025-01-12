class Solution {
    public int getMinimumDifference(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) 
            return 0;
        List<Integer> nodes = new ArrayList<>();
        preOrder(root, nodes);
        Collections.sort(nodes);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (Math.abs(nodes.get(i) - nodes.get(i + 1)) < min) 
                min = Math.abs(nodes.get(i) - nodes.get(i + 1));
        }
        return min;
    }

    public void preOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        preOrder(root.left, nodes);
        preOrder(root.right, nodes);
    }
}