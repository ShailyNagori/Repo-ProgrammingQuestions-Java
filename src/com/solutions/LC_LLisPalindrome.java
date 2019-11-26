package com.solutions;

/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
 */

import com.commons.ListNode;

public class LC_LLisPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return  true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {  //Odd number of nodes
            slow = slow.next; //Let right part be smaller
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if(fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode next = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        LC_LLisPalindrome obj = new LC_LLisPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        boolean res = obj.isPalindrome(head);
        System.out.println(res);

    }
}
