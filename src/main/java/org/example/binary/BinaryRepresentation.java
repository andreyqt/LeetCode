package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/">Number of Steps to Reduce a Number in Binary Representation to One</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class BinaryRepresentation {


    public int numberOfSteps(String s) {
        int steps = 0, carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int digit = (s.charAt(i) - '0') + carry;

            if (digit == 0) {
                steps += 1;
                carry = 0;
            } else if (digit == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
                carry = 1;
            }
        }
        return steps + carry;
    }

}
