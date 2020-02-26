package ua.nure.panchenko.practice6.part6;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Part63 {
    private List<Word2> arr = new ArrayList<>();
    private List<String> arr2 = new ArrayList<>();

    public Part63(String[] input) {
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
    }

    private void reduce() {
        for (int i = 0; i < arr.size(); i++) {
            if (arr2.size() == 3) {
                break;
            }
            if (arr.get(i).getFrequency() > 1) {
                arr2.add(arr.get(i).getContent());
            }
        }
    }

    public void output() {
        for (String str: arr2) {
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString().toUpperCase(new Locale("en")));
        }
    }
}
