// 142.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Floyd's Algorithm - fast and slow pointers
//have slow and fast at the head and move forward slow by one step & fast by 2 steps till fast != null(even length list) or fast.next != null(odd length list)
//if at any point fast and slow are same, then there is a cycle
//to get the start of cycle, move head and slow forward by one step till they meet

//time - O(n)
//space - constant
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
        {
            return null; //edge
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                while(slow != temp)
                {
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow; //or temp
            }
        }
        return null;
    }
}
