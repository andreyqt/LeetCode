package org.example.string_tasks;

/**
 * task: <a href="https://leetcode.com/problems/find-unique-binary-string/">Find Unique Binary String</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class FindUniqueBinString {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = nums[i].charAt(i);
            sb.append((char) '1' - ch);
        }
        return sb.toString();
    }

}
