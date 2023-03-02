package selfpractice;

import java.util.Stack;

import common.InputReader;

/**
 * Generate all subsequence
 */
public class AllSubsequenceArr {
    public static void main(String[] args) {
        subseq(InputReader.readIntArray(), 0, new Stack<>());
    }

    public static void subseq(int[] input, int i, Stack<Integer> stack) {
        if (i == input.length) {
            if (!stack.isEmpty()) {
                System.out.println(stack.toString());
            }
            return;
        }

        subseq(input, i + 1, stack);

        stack.push(input[i]);
        subseq(input, i + 1, stack);
        stack.pop();
    }
}
