package Monney;

public class CommentWrap {
    public static void main(String[] argv) {
        StringBuilder str = new StringBuilder("//" +
                " This is a fairly long comment. I don't know who would ever write something like this, but I'm going to do it anyway as an example. Note that the web browser is automatically wrapping the text so you don't have to scroll horizontally. But all these words are on the same line.\n");
        String strd = new String("This is a fairly long comment. I don't know whowould ever write something like");
        System.out.println(strd.length());
        String c = "";
        if (str.indexOf("/**") == 0)
            c = new String("*");
        if (str.indexOf("//") == 0)
            c = new String("//");
        for (int i = 80; i < str.length(); ) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                i--;
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                i--;
            else{
                System.out.println(i);
                String d = "\n" + c;
                str.insert(i,d);
                i += 80;
            }
        }
        System.out.println(str);
    }
}
