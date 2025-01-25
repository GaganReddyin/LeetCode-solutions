class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;

        for(int i = 0; i < n; i++){
            nums1[i] = nums1[i] - nums2[i];
        }
        Tree tree = new Tree();

        long res = 0;
        for(int i = 0; i < n; i++){
            int val = nums1[i] + diff;
            res += tree.find(val);
            tree.insert(nums1[i]);
        }

        return res;
    }
}

class Node {
    int val;
    int count;

    Node left;
    Node right;

    Node(int val, int count){
        this.val = val;
        this.count = count;
    }
}

class Tree {
    Node root;

    Tree(){}

    void insert(int val){
        root = insertHelper(root, val);
    }

    Node insertHelper(Node root, int val){
        if(root == null) return new Node(val, 1);

        if(root.val == val) {
            root.count++;
            return root;
        }

        if(val < root.val){
            root.count++;
            root.left = insertHelper(root.left, val);
        } else {
            root.right = insertHelper(root.right, val);
        }

        return root;
    }

    int find(int val){
        return findHelper(root, val);
    }

    int findHelper(Node root, int val){
        if(root == null) return 0;

        if(val < root.val) return findHelper(root.left, val);
        else return root.count + findHelper(root.right, val);
    }

}