package com.solutions;
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */

public class LC_firstUniqChar {
    private int firstUniqChar(String s) {
        int[] freq = new int[26];
        int[] loc = new int[26];
        int n = s.length();
        int ret = -1;
        for(int i = 0 ; i< n; i++) {
            freq[s.charAt(i) - 'a']++;
            loc[s.charAt(i) - 'a'] = i;

        }
        for(int i = 0; i< 26; i++) {
            if(freq[i] == 1) {
                ret = ret == -1 ? loc[i] : Math.min(ret, loc[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC_firstUniqChar obj = new LC_firstUniqChar();
        String s = "loveleetcode";
        int res = obj.firstUniqChar(s);
        System.out.println(res);
    }
}
