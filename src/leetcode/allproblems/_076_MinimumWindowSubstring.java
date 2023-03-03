package leetcode.allproblems;

import common.InputReader;

import java.util.HashMap;
import java.util.Map;

public class _076_MinimumWindowSubstring {
    public static void main(String[] args) {
        String[] strings = InputReader.readStringArray(2);
        System.out.println(new _076_MinimumWindowSubstring().solve(strings[0], strings[1]));
    }

    private String solve(String s, String t) {
        Map<Character, Long> countT = new HashMap<>();
        Map<Character, Long> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int have = 0;
        int need = countT.size();
        int l = 0;
        int reslen = Integer.MAX_VALUE;
        String ret = "";
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            window.compute(rc, (k, v) -> (v == null) ? 1 : v + 1);

            if (countT.containsKey(rc) && window.get(rc).equals(countT.get(rc))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 < reslen) {
                    reslen = r - l + 1;
                    ret = s.substring(l, r + 1);
                }
                char lc = s.charAt(l);
                window.computeIfPresent(lc, (k , v) -> v - 1);
                if (countT.containsKey(lc) && window.get(lc) < countT.get(lc)) {
                    have--;
                }
                l++;
            }
        }
        return ret;
    }
}
