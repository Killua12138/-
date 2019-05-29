package IO;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] argv) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("src\\IO\\MemoryInput.java"));
        int c;
        while ( (c = in.read()) != -1)
            System.out.print((char) c);
    }

}
