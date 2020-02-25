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

    // преобразовываем текст в массив строк
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
        if (!(str.equals("--input") || str.equals("-i"))) {
            System.err.println("Wrong operation");
//            return false;
        }
        setFilename(filename);
        if (!(str2.equals("--task") || str2.equals("-t"))) {
            System.err.println("Wrong task");
//            return false;
        }
        if (operation.equals("frequency")) {
            arrInitialize();
            Part61 part61 = new Part61(arr);
            part61.output();
//            return true;
        } else if (operation.equals("length")) {
            arrInitialize();
            Part62 part62 = new Part62(arr);
            part62.output();
//            return true;
        } else if (operation.equals("duplicates")) {
            arrInitialize();
            Part63 part63 = new Part63(arr);
            part63.output();
        }
//        return true;
    }

    public static void main(String[] args) {
        Part6 part6 = new Part6();
        part6.consoleOutput(args[0], args[1], args[2], args[3]);
    }

}
