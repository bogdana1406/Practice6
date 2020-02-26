package ua.nure.panchenko.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private String filename;
    private String text;
    private String[] arr;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public final void arrInitialize() {
        try {
            StringBuilder sb = new StringBuilder();
            Scanner sc = new Scanner(new File(getFilename()), "CP1251");
            while (sc.hasNext()) {
                sb.append(sc.next() + " ");
            }
            text = sb.toString();
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File " + getFilename() + " not found");
        }
        arr = initialize();
    }

    public final String[] initialize() {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[A-za-zА-Яа-я]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            sb.append(m.group() + " ");
        }
        return sb.toString().split(" ");
    }

    public void consoleOutput(String str, String filename, String str2,
                              String operation) {
        if (!("--input".equals(str) || "-i".equals(str))) {
            System.err.println("Wrong operation");
        }
        setFilename(filename);
        if (!("--task".equals(str2) || "-t".equals(str2))) {
            System.err.println("Wrong task");
        }
        switch (operation) {
            case ("frequency"):
                arrInitialize();
                Part61 part61 = new Part61(arr);
                part61.output();
                break;
            case ("length"):
                arrInitialize();
                Part62 part62 = new Part62(arr);
                part62.output();
                break;
            case ("duplicates"):
                arrInitialize();
                Part63 part63 = new Part63(arr);
                part63.output();
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }

    public static void main(String[] args) {
        Part6 part6 = new Part6();
        part6.consoleOutput(args[0], args[1], args[2], args[3]);
    }

}
