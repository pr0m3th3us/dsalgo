package leetcode.allproblems;

import common.InputReader;

import java.util.HashMap;
import java.util.Map;

public class _242_Valid_Anagrams {
    public static void main(String[] args) {
        String[] strings = InputReader.readStringArray(2);
        System.out.println(new _242_Valid_Anagrams().isAnagram(
                strings[0], strings[1]
        ));
    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = 1;
            if (map.containsKey(c)) {
                count = 1 + map.get(c);
            }
            map.put(c, count);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            int count = map.get(c) - 1;
            map.put(c, count);
            if (count == 0) map.remove(c);
        }
        return map.isEmpty();
    }
}
