package ua.nure.panchenko.practice6.part6;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Part62 {
    private List<Word2> arr = new ArrayList<>();
    private Set<String> set = new LinkedHashSet<>();
    private List<Word2> arr2 = new ArrayList<>();

    public Part62(String[] input) {
        fillSet(input);
        fill();
        reduce();
    }

    private void fillSet(String[] input) {
        set.addAll(Arrays.asList(input));
    }

    private void add(Word2 word) {
            word.setContent(word.getContent());
            word.setFrequency(word.getContent().length());
            arr.add(word);
    }
    private void fill() {
        for (String str: set) {
            add(new Word2(str));
        }
        arr.sort(new CompareByFrequency());
    }

    private void reduce() {
        for (int i = 0; i < 3; i++) {
            arr2.add(arr.get(i));
        }
    }

    public void output() {
        for (Word2 word: arr2) {
            System.out.println(word.getContent() + " ==> " + word.getFrequency());
        }
    }
}
