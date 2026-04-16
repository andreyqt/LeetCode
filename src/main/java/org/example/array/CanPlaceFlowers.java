package org.example.array;

/**
 * task: <a href="https://leetcode.com/problems/can-place-flowers/">Can Place Flowers</a><br>
 * time complexity: {@code O(n)}<br>
 * space complexity: {@code O(n)}<br>
 * difficulty: {@code easy}
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] array = new int[flowerbed.length + 2];
        array[0] = 0;
        array[flowerbed.length + 1] = 0;

        System.arraycopy(flowerbed, 0, array, 1, flowerbed.length);

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i + 1] == 0 && array[i - 1] == 0) {
                array[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

}
