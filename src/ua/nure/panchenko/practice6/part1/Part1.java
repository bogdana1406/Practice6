package ua.nure.panchenko.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class Part1 {

    public static void main(String[] args) {
        try {
            System.setIn(new ByteArrayInputStream(
                    "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(System
                            .getProperty("file.encoding"))));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported encoding");
        }
        WordContainer.main(args);
        System.setIn(System.in);

    }

}
