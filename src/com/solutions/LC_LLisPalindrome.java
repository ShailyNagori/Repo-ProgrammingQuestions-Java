package com.solutions;

/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
 */

public class LC_LLisPalindrome {
    public boolean isPalindrome(LC2_Add2Numbers.ListNode head) {
        if(head == null || head.next == null) return  true;
        LC2_Add2Numbers.ListNode fast = head;
        LC2_Add2Numbers.ListNode slow = head;
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
    public LC2_Add2Numbers.ListNode reverse(LC2_Add2Numbers.ListNode head) {
        LC2_Add2Numbers.ListNode next = head;
        LC2_Add2Numbers.ListNode curr = head;
        LC2_Add2Numbers.ListNode prev = null;
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
        LC2_Add2Numbers.ListNode head = new LC2_Add2Numbers.ListNode(1);
        head.next = new LC2_Add2Numbers.ListNode(2);
        head.next.next = new LC2_Add2Numbers.ListNode(1);
        boolean res = obj.isPalindrome(head);
        System.out.println(res);

    }
}
