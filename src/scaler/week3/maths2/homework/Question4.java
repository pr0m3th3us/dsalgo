package scaler.week3.maths2.homework;

import java.util.ArrayList;

import common.InputReader;

/**
 * Solve sub-sequences and return OR Problem Description
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some elements without changing the order of the remaining elements.
 * For example, the sequence {2, 3, 5} is a subsequence of {1, 2, 3, 4, 5}
 * obtained after removal of elements {1, 4}.
 * 
 * Given is an array of integers A of size N. An array of size N can have (2^N -
 * 1) number of non empty subsequences.
 * 
 * For the given function:
 * 
 * solve (int subsequence[]) { int count[]; //array initialised to 0. for(int i
 * = 0; i &amp;lt; subsequence.length; i++) { number = subsequence[i]; for(int j
 * = 2; j &amp;lt;= number; j++) { if(number % j == 0) { count[j]++; if(count[j]
 * == subsequence.length) return 0; } } } return 1; } If all the subsequences of
 * the array A are passed in the above function. What will be the bitwise OR of
 * all the returned values from the given function.
 * 
 * 
 * 
 * Problem Constraints 1 <= length of the array <= 100000 1 <= A[i] <= 109
 * 
 * 
 * 
 * Input Format The only argument given is the integer array A.
 * 
 * 
 * 
 * Output Format Return the bitwise OR of all the returned values.
 * 
 * 
 * 
 * Example Input Example Input 1:
 * 
 * A = [1, 2, 3] Example Input 2:
 * 
 * A = [2, 4, 6, 8]
 * 
 * 
 * Example Output Example Output 1:
 * 
 * 1 Example Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * If you pass {1} in function, it return 1. as A|1 = 1. answer will be 1.
 */
public class Question4 {
    public static void main(String[] args) {
        System.out.println(solve(InputReader.readIntArraylist()));
    }

    public static int solve(ArrayList<Integer> A) {
        if (A.isEmpty()) return 1;
        if (A.size() == 1) return A.get(0);
        int gcd = gcd(A.get(0), A.get(1));

        for (int i = 2; i < A.size(); i++) {
            gcd = gcd(gcd, A.get(i));
        }
        return gcd == 1 ? 1 : 0;
    }

    private static int gcd(int a, int b) {
        int i = a < b ? b : a;
        int j = a < b ? a : b;

        if (j == 0) return i;
        return gcd(i % j, j);
    }
}
