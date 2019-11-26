package com.solutions;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */

import java.util.HashSet;
import java.util.Set;


public class LC3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = 0;
        int left = 0;
        int res = 0;
        while (right < s.length()) {
            if(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            else {
                set.add(s.charAt(right++));
                res = Math.max(res,set.size());
            }

        }
        return res;

    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LC3_LengthOfLongestSubstring obj = new LC3_LengthOfLongestSubstring();
        int res = obj.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
