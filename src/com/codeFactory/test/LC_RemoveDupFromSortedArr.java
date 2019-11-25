package com.codeFactory.test;

/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

E.g.
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.

e.g. 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.

 */

public class LC_RemoveDupFromSortedArr {
    public  int removeDuplicate(int[] arr) {
        if(arr.length == 0) return 0;
        int i = 0, j = i+1;
        while(j < arr.length) {
            if(arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4} ;
        LC_RemoveDupFromSortedArr obj = new LC_RemoveDupFromSortedArr();
        int res = obj.removeDuplicate(nums);
        System.out.println(res);
    }
}
