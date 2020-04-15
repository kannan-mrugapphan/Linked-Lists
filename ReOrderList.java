// 143.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time - O(n) with constant space
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
        {
            return; //edge
        }
        
        ListNode middle = findMiddle(head); //time - O(n) with constant space
        ListNode l2 = reverseList(middle.next); //time - O(n) with constant space
        middle.next = null;
        ListNode l1 = head;
        head = mergeLists(l1, l2); //time - O(n) with constant space
        return;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode temp1;
        ListNode temp2;
        
        while(head2 != null)
        {
            temp1 = head1.next;
            head1.next = head2;
            temp2 = head2.next;
            if(temp1 == null)
            {
                break;
            }
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
        
        return l1;
    }
}
