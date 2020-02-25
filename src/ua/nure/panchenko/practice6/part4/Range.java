package ua.nure.panchenko.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer>{
    private int[] arr;
    private boolean reverse;
    private int start;

    public Range(int start, int end) {
        this.start = start;
        arr = new int[end - start + 1];
        fillArray();
    }

   public Range(int start, int end, boolean reverse) {
        this.start = start;
        setReverse(reverse);
        arr = new int[end - start + 1];
        fillArray();
    }

    public final void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public final void fillArray() {
        int local = start;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = local;
            local++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        private int pointer;

        RangeIterator() {
            if (reverse) {
                setPointer(arr.length);
            } else {
                setPointer(-1);
            }
        }

        public int getPointer() {
            return pointer;
        }

        public final void setPointer(int pointer) {
            this.pointer = pointer;
        }

        @Override
        public boolean hasNext() {
            if (reverse) {
                if (getPointer() - 1 >= 0) {
                    return true;
                }
                return false;
            } else {
                if (getPointer() + 1 < arr.length) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (reverse) {
                setPointer(getPointer() - 1);
                return arr[pointer];
            } else {
                setPointer(getPointer() + 1);
                return arr[pointer];
            }
        }
    }
}
