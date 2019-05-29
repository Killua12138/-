package IO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] argv) throws IOException {
        DataInputStream  in = new DataInputStream((
                new ByteArrayInputStream(BufferedInputFile.read(
                        "src\\IO\\FormattedMemoryInput.java").getBytes())));
        while (true)
            System.out.print((char) in.readByte());
    }
}
