/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        return  post_order(root,list);
    }
    public List<Integer> post_order(Node node,List<Integer> list){
      for(Node child:node.children){
        if(child!=null){
            post_order(child,list);
        }
      }
      list.add(node.val);
      return list;
    }
}