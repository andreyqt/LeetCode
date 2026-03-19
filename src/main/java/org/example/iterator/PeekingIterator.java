package org.example.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * task: <a href="https://leetcode.com/problems/peeking-iterator/description/">Peeking Iterator</a><br>
 * time complexity: {@code O(1)} for all operations<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextInteger;
    private boolean hasNext;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;

        if (iterator.hasNext()) {
            nextInteger = iterator.next();
            hasNext = true;
        } else {
            hasNext = false;
            //nextInteger = null;
        }
    }

    public Integer peek() {
        if (hasNext) {
            return nextInteger;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }

        Integer next = nextInteger;

        if (iterator.hasNext()) {
            nextInteger = iterator.next();
        } else {
            hasNext = false;
            nextInteger = null;
        }

        return next;
    }

}
