/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp != null){
            Node t = temp.next;
            if(temp.child != null){
                Node c = flatten(temp.child);
                temp.next = c; // connection to child
                c.prev = temp;

                while(c.next != null){
                    c = c.next;
                }
                c.next = t; // Connection to remaining List after child's completion
                if(t != null) t.prev = c;
            }
            temp.child = null; // VVIP for DLL
            temp = t;
        }
        return head;
    }
}