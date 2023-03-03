package leetcode.allproblems;

import java.util.HashSet;

public class _003_LongestSubstringWithoutRepetition {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        HashSet<Character> uniques = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            while (uniques.contains(chars[right])) {
                uniques.remove(chars[left]);
                left++;
            }
            uniques.add(chars[right]);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
