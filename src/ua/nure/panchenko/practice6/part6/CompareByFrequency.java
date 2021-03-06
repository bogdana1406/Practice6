package ua.nure.panchenko.practice6.part6;

import java.io.Serializable;
import java.util.Comparator;

public class CompareByFrequency implements Comparator<Word2>, Serializable {
    private static final long serialVersionUID = -6424334161582552937L;

    @Override
    public int compare(Word2 o1, Word2 o2) {
        return -(o1.getFrequency() - o2.getFrequency());

    }
}
