package scaler.week3.maths2.assignment;

import java.util.ArrayList;

import common.InputReader;

/**
 * Delete Elements
Problem Description

Given an integer array A of size N.
Find the minimum number of elements that need to be removed such that the GCD of the resulting array becomes 1.

If not possible then return -1.



Problem Constraints
1 <= N <= 100000
1 <= A[i] <= 1e9


Input Format
Input contains a single integer array A



Output Format
Return an integer



Example Input
Input 1:

 A = [7, 2, 5]


Example Output
Output 1:

 0


Example Explanation
Explanation 1:

 GCD of the array A is 1.
 so, the number of elements to be removed is 0.
 */
public class Question4 {
    public static void main(String[] args) {
        System.out.println(solve(InputReader.readIntArraylist()));
    }

    public static int solve(ArrayList<Integer> A) {
        int gcd = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            gcd = gcd(gcd, A.get(i));
        }
        return gcd == 1 ? 0 : -1;
    }

    private static int gcd(int _a, int _b) {
        int greater = _a > _b ? _a : _b;
        int lesser = _a < _b ? _a : _b;
        while(greater != 0 && lesser != 0) {
            int temp = lesser;
            lesser = greater % lesser;
            greater = temp;
        }
        return greater;
    }
}
