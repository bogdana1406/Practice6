package ua.nure.panchenko.practice6.part6;

import java.util.ArrayList;
import java.util.List;

public class Part61 {
    private List<Word2> arr = new ArrayList<>();
    private List<Word2> arr2 = new ArrayList<>();

    public Part61(String[] input) {
        fill(input);
        reduce();
    }

    private void add(Word2 word) {
        for (Word2 w : arr) {
            if (w.getContent().equals(word.getContent())) {
                w.setFrequency(w.getFrequency() + 1);
                return;
            }
        }
        arr.add(word);
    }

    private void fill(String[] input) {
        for (int i = 0; i < input.length; i++) {
                add(new Word2(input[i]));
        }
        arr.sort(new CompareByFrequency());
    }

    private void reduce() {
        for (int i = 0; i < 3; i++) {
            arr2.add(arr.get(i));
        }
        arr2.sort(new CompareByWord());
    }

    public void output() {
        for (Word2 word: arr2) {
            System.out.println(word.getContent() + " ==> " + word.getFrequency());
        }
    }
}
