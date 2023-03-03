package leetcode.allproblems;

import common.InputReader;

import java.util.Map;
import java.util.TreeMap;

public class _975_OddEvenJump {
    public static void main(String[] args) {
        System.out.println(new _975_OddEvenJump().oddEvenJumps(InputReader.readIntArray()));
    }

    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] high = new boolean[n], low = new boolean[n];

        high[n - 1] = true;
        low[n - 1] = true;

        int count = 1;

        TreeMap<Integer, Integer> valueToIdx = new TreeMap<>();
        valueToIdx.put(arr[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> nextSmallest = valueToIdx.floorEntry(arr[i]), nextLargest = valueToIdx.ceilingEntry(arr[i]);
            high[i] = nextLargest != null && low[nextLargest.getValue()];
            low[i] = nextSmallest != null && high[nextSmallest.getValue()];
            valueToIdx.put(arr[i], i);

            if (high[i]) {
                count++;
            }
        }

        return count;
    }
}
