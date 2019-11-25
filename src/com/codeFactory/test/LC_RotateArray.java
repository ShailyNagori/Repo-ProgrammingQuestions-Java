package com.codeFactory.test;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

public class LC_RotateArray {
    public void rotateArr(int[] arr , int k) {
        int n = arr.length;
        if(n < 2) return ;
        int kk = k %10;

        //rotate right
        reverse(arr,0,n-1);
        reverse(arr,0, kk-1);
        reverse(arr, kk, n-1);

        //rotate left
        /*
        reverse(arr, 0, kk-1);
        reverse(arr, kk, n-1);
        reverse(arr,0, n-1)
        */
    }
    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (end>start) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7};
        LC_RotateArray obj = new LC_RotateArray();
        obj.rotateArr(arr,3);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
