// 206. 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return null; //edge
        }
        //return iterativeReversal(head);
        return recursiveReversal(head);
    }
    
    //time - O(n) with constant space
    private ListNode iterativeReversal(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    //time - O(n) with n space for recursive stack
    private ListNode recursiveReversal(ListNode head) {
        //base
        if(head.next == null)
        {
            return head;
        }
        //logic
        ListNode current = recursiveReversal(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }
    
    //1-2-3-4-null -> 2-3-4-null -> 3-4-null -> 4-null
    //                           <- 4-3-null
    //             <- 4-3-2-null
    //<- 4-3-2-1-null
}
