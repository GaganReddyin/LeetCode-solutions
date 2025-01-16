/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int serializedTreeIndexPointer;
    public String serialize(TreeNode root) {
      StringBuilder serializedTree = new StringBuilder();
      preorder(root, serializedTree);
      return serializedTree.toString();
    }
    
   void preorder(TreeNode root, StringBuilder serializedTree) {
       if (root == null) {
          return;
       }

        serializedTree.append(root.val).append(",");
        preorder(root.left, serializedTree);
        preorder(root.right, serializedTree);
   }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String serializedTree) {
        serializedTreeIndexPointer = 0;
        String serializedArray[] = serializedTree.split(",");
        return treeBuilder(serializedArray, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    
    TreeNode treeBuilder(String serializedArray[], int min, int max) {
        if (serializedTreeIndexPointer >= serializedArray.length)
            return null;
        
        Integer a = parseStringToInt(serializedArray[serializedTreeIndexPointer]);
         if ( a == null || a > max || a < min) {
          return null;
         }

       TreeNode root = new TreeNode(Integer.parseInt(serializedArray[serializedTreeIndexPointer++]));
       root.left = treeBuilder(serializedArray, min, root.val);
       root.right = treeBuilder(serializedArray, root.val, max);
        
       return root;
    }
    
    Integer parseStringToInt(String s) {
        try {
          return Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return null;}
    }
}