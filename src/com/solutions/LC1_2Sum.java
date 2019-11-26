package com.solutions;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class LC1_2Sum {

    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        if(nums.length < 2)
            throw new IllegalAccessException("Array doesnt have enough elements to calculate the sum");
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment)) {
                return new int[]{map.get(compliment),i} ;
            }
            else
                map.put(nums[i],i);
        }
        throw new IllegalAccessException("No two sum solution");
    }

    public static void main(String[] args) throws IllegalAccessException {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        LC1_2Sum obj = new LC1_2Sum();
        int[] res = obj.twoSum(nums,target);
        for(int i = 0; i< res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
