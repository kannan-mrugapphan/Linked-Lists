// 19.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time - O(n) with constant space
//two pass - find length of list, move forward by one step from head till n-1th node, remove nth node
//the previous node is reached when length - n = 1
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        {
            return null; //edge
        }
        //return removeNth2Pass(head, n);
        return removeNth(head, n);
    }
    
    private ListNode removeNth(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int fastPosition = 0;
        while(fastPosition <= n)
        {
            fast = fast.next;
            fastPosition++;
        }
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    
    private ListNode removeNth2Pass(ListNode head, int n) {
        // 1-2-3-4-5-6 with n = 2 o/p - 1-2-3-4-6
        // dummy-1-2-3-4-5-6 have temp at dummy and move dummy by (6-2) steps
        // remove next of temp and return dummy.next(head)
        int length = findLength(head);
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        int moves = length - n;
        ListNode temp = dummy;
        while(moves > 0)
        {
            temp = temp.next;
            moves--;
        }
        temp.next = temp.next.next; //remove n th node
        return dummy.next;
    }
    
    private int findLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
