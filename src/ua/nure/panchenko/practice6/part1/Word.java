package ua.nure.panchenko.practice6.part1;

public class Word implements Comparable<Word>{
    private String content;

    private int frequency;

    public Word(String content) {
        this.content = content;
        frequency = 1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word o) {
        if (frequency > o.getFrequency()) {
            return -1;
        } else if (frequency == o.frequency) {
            return content.compareTo(o.getContent());
        } else {
            return 1;
        }
    }
}
