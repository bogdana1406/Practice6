package ua.nure.panchenko.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    private int number;
    private static final int COUNTER = 10000;
    private List<Integer> list1;
    private List<Integer> list2;
    private List<Integer> list3;
    private List<Integer> list4;

    Part2(int number) {
        setNumber(number);
        list1 = new ArrayList<>();
        list2 = new LinkedList<>();
        list3 = new ArrayList<>();
        list4 = new LinkedList<>();
        fillArrays();
    }

    public final int getNumber() {
        return number;
    }

    public final void setNumber(int number) {
        this.number = number;
    }

    public final void fillArrays() {
        for (int i = 0; i < getNumber(); i++) {
            list1.add(i);
            list2.add(i);
            list3.add(i);
            list4.add(i);
        }
    }

    public static long removeByIndex(List<Integer> list, int counter) {
        long time = System.currentTimeMillis();
        int local = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.size() == 1) {
                break;
            }

            local += (counter - 1);

            while (local >= list.size()) {
                local = local - list.size();
            }
            list.remove(local);
        }
        return System.currentTimeMillis() - time;
    }

    public static long removeByIterator(List<Integer> list, int counter) {
        long time = System.currentTimeMillis();
        int local = 0;
        Iterator<Integer> iterator = list.iterator();
        while (list.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                local++;
                if (local == counter) {
                    iterator.remove();
                    local = 0;
                }
            } else {
                iterator = list.iterator();
            }

        }
        return System.currentTimeMillis() - time;
    }

    public static void main(String[] args) {
        Part2 pt2 = new Part2(COUNTER);

        System.out.println("ArrayList1Index: " + removeByIndex(pt2.list1, 3));
        System.out.println("LinkedList2Index: " + removeByIndex(pt2.list2, 3));
        System.out.println("ArrayList1Iterator: " + removeByIterator(pt2.list3, 3));
        System.out.println("LinkedList2Iterator: " + removeByIterator(pt2.list4, 3));
    }

}
