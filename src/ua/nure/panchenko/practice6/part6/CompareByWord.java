package ua.nure.panchenko.practice6.part6;

import java.io.Serializable;
import java.util.Comparator;

public class CompareByWord implements Comparator<Word2>, Serializable {
    private static final long serialVersionUID = 1933053173504791546L;

    @Override
    public int compare(Word2 o1, Word2 o2) {
        return o2.getContent().compareTo(o1.getContent());
    }
}
