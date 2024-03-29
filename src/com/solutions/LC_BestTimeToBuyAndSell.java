package com.solutions;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */



public class LC_BestTimeToBuyAndSell {
    public int bestTimeToBuyAndSell(int[] arr) {
        int i = 0;
        if(arr.length == 0) return 0;
        int peak = arr[0];
        int valley = arr[0];
        int profit = 0;
        while(i < arr.length - 1) {
            while (i < arr.length - 1 && arr[i] >= arr[i+1]) {
                i++;
            }
            valley = arr[i];
            while (i < arr.length - 1 && arr[i] <= arr[i+1]) {
                i++;
            }
            peak = arr[i];
            profit += peak - valley;
        }
        return profit;
    }

    public static void main(String[] args) {
        LC_BestTimeToBuyAndSell obj = new LC_BestTimeToBuyAndSell();
        int[] arr = new int[] {7,1,5,3,6,4};
        int res = obj.bestTimeToBuyAndSell(arr);
        System.out.println(res);
    }
}
