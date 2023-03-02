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
public class Question5 {
    static int N = 1000000;
    static int[] divisors = new int[N + 1];

    public static void main(String[] args) {
        System.out.println(new Question5().solve(InputReader.readIntArraylist()));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        fillDivisors();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i : A) {
            B.add(divisors[i]);
        }
        return B;
    }

    private static void fillDivisors() {
        divisors[1] = 1;
        for(int i = 2; i <= N; i++) {
            divisors[i] = 2;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 2 * i; j <= N; j += i) {
                divisors[j]++;
            }
        }
    }
}
