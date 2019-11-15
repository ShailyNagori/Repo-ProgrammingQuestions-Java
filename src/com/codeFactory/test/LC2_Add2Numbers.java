package com.codeFactory.test;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

import java.util.LinkedList;



public class LC2_Add2Numbers {
    static  ListNode head1, head2;
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode add2Numbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = null;
        ListNode temp = null;
        ListNode prev = null;
        int sum , carry = 0;

        while(l1 != null || l2 != null) {
            sum = carry + (l1 != null ? l1.val: 0) + (l2 != null ? l2.val : 0);
            carry = (sum >= 10 ? 1: 0);
            sum = sum % 10;
            temp = new ListNode(sum);
            if(res == null)
                res = temp;
            else {
                prev.next = temp;
            }
            prev = temp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return res;
    }

    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LC2_Add2Numbers list = new LC2_Add2Numbers();

        // creating first list
        list.head1 = new ListNode(2);
        list.head1.next = new ListNode(4);
        list.head1.next.next = new ListNode(3);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        list.head2 = new ListNode(5);
        list.head2.next = new ListNode(6);
        list.head2.next.next = new ListNode(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        ListNode rs = list.add2Numbers(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);



    }
}
