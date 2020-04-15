// 160.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//time - O(n) with constant space
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //find length of both linked lists
        int lengthOfA = findLength(headA);
        int lengthOfB = findLength(headB);
        
        //move forward by difference in lengths in the longer list
        int lengthDeifference = Math.abs(lengthOfA - lengthOfB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        if(lengthOfA > lengthOfB)
        {
            while(lengthDeifference != 0)
            {
                tempA = tempA.next;
                lengthDeifference--;
            }
        }
        else
        {
            while(lengthDeifference != 0)
            {
                tempB = tempB.next;
                lengthDeifference--;
            }    
        }
        
        //move forward by one step in both lists till node is same
        while(tempA != tempB)
        {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return tempA; //or tempB
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
