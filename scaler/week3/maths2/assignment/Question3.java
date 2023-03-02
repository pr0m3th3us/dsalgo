package scaler.week3.maths2.assignment;

import java.util.ArrayList;

import common.InputReader;

/**
 * Count of divisors
Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: Order of the resultant array should be same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format
The only argument given is the integer array A.



Output Format
Return the count of divisors of each element of the array in the form of an array.



Example Input
Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output
Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
 */
public class Question3 {
    public static void main(String[] args) {
        System.out.println(solve(InputReader.readIntArraylist()));
    }

    public static int solve(ArrayList<Integer> A) {
        if (A.size() == 2) return Math.max(A.get(0), A.get(1));

        int max = Integer.MIN_VALUE;
        int[] prefix = prefix(A);
        int[] suffix = suffix(A);
        for(int i = 0; i < A.size(); i++) {
            int gcdi;
            if (i == 0) {
                gcdi = suffix[i + 1];
            } else if (i == A.size() - 1) {
                gcdi = prefix[i - 1];
            } else {
                gcdi = gcd(prefix[i - 1], suffix[i + 1]);
            }
             
            max = Math.max(max, gcdi);
        }

        return max;
    }

    private static int gcd(int _a, int _b) {
        int a = _a > _b ? _a : _b;
        int b = _a < _b ? _a : _b;
        while(a !=0 && b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static int[] prefix(ArrayList<Integer> A) {
        int[] ret = new int[A.size()];
        ret[0] = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            ret[i] = gcd(ret[i - 1], A.get(i));
        }
        return ret;
    }

    private static int[] suffix(ArrayList<Integer> A) {
        int n = A.size();
        int[] ret = new int[n];
        ret[n - 1] = A.get(n - 1);
        for(int i = n - 2; i >= 0; i--) {
            ret[i] = gcd(ret[i + 1], A.get(i));
        }
        return ret;
    }
}
