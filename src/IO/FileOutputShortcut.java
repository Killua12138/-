package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";

    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("src/IO/FileOutputShortcut.java"))
        );
        PrintWriter out = new PrintWriter(file);
        int countLine = 1;
        String s;
        while (( s = in.readLine()) != null )
            out.println(countLine++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }

}
