package Monney;

import java.util.LinkedList;

public class EncrypAndDecryp {
    private Pontifex pontifex;
    private String text;
    private int[] keyStream;
    public EncrypAndDecryp(Pontifex pontifex, String text) {
        this.pontifex = pontifex;
        this.text = getValid(text);
    }

    public String Decryp() {
        int[] keyStream = pontifex.getKeyStream();
        String str = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int ascii = ((c - 'A') + keyStream[i]) % 26;
            char d = (char) (ascii + 'A');
            System.out.print(c + " " +(c - 'A' + 1)+ " " + keyStream[i] + " "+ (ascii + 1)+" "+d);
            System.out.println();
            str = str + d;
        }
        return str;
    }

    public String getValid(String str) {
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))
                newstr += c;
        }
        return newstr.toUpperCase();
    }
    public static void main(String[] argv){
        LinkedList<Integer> list = new LinkedList<>();
        int[] a = {21, 16, 10, 9, 5, 1, 13, 14, 17, 22, 23, 4, 20, 28, 6, 2, 24, 19, 15, 27, 18, 26, 25, 11, 12, 7, 8, 3};
        for (int i : a)
            list.add(i);
        Pontifex pontifex = new Pontifex(list, 10);
        EncrypAndDecryp test = new EncrypAndDecryp(pontifex,"Do not use PC.");
        test.Decryp();
    } 
}
