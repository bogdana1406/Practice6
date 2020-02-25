package ua.nure.panchenko.practice6.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordContainer {

    private List<Word> arr = new ArrayList<>();

    private void add(Word word) {
        for (Word w : arr) {
            if (w.getContent().equals(word.getContent())) {
                w.setFrequency(w.getFrequency() + 1);
                return;
            }
        }
        arr.add(word);
    }

    private static String[] input() {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in, System.getProperty("file.encoding"));
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine() + " ");
        }
        sc.close();
        return sb.toString().split(" ");
    }

    private void fill(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (!"stop".equals(input[i])) {
                add(new Word(input[i]));
            } else {
                break;
            }
        }
        arr.sort(Word::compareTo);
    }

    private void output() {
        for (Word word: arr) {
            System.out.println(word.getContent() + " : " + word.getFrequency());
        }
    }

    public static void main(String[] args) {
        WordContainer wc = new WordContainer();
        String[] input = input();
        wc.fill(input);
        wc.output();
    }

}
