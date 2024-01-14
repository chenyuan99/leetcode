// package VO;

// Java program for above approach
import java.io.*;

public class SmallestStringDivisibleByTwoGivenString {

    // Function to calculate
    // GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to calculate
    // LCM of two numbers
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    // Function to find the smallest string
    // which is divisible by strings S and T
    public static void findSmallestString(String s, String t) {
        // Store the length of both strings
        int n = s.length(), m = t.length();

        // Store LCM of n and m
        int l = lcm(n, m);

        // Temporary strings to store
        // concatenated strings
        String s1 = "", t1 = "";

        // Concatenate s1 (l / n) times
        for (int i = 0; i < l / n; i++) {
            s1 += s;
        }

        // Concatenate t1 (l / m) times
        for (int i = 0; i < l / m; i++) {
            t1 += t;
        }

        // If s1 and t1 are equal
        if (s1.equals(t1)) {
            System.out.println(s1);
        }

        // Otherwise, print -1
        else {
            System.out.println(-1);
        }
    }

    // Driver code
    public static void main(String[] args) {

        String S = "baba", T = "ba";
        findSmallestString(S, T);
    }
}

// This code is contributed by susmitakundugoaldanga.
