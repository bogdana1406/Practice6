package ua.nure.panchenko.practice6.part6;

public class Word2 {

    private String content;
    private int frequency;

    public Word2(String content) {
        this.content = content;
        frequency = 1;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
