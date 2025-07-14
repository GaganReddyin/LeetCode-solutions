/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) 
    {
        int size=-1;
        ListNode temp=head;

        while(head!=null)
        {
            size++;
            head=head.next;
        }
        int ans=0;
        while(temp!=null)
        {
            if(temp.val==1)
           ans+=Math.pow(2,size);
           temp=temp.next;
           size--;
        }
        return ans;
        
    }
}