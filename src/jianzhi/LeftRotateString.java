package jianzhi;

public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        int k = n % str.length();
        String last = str.substring(0, k);
        String first = str.substring(k, str.length());
        return first + last;
    }
    public static void main(String[] argv){
        LeftRotateString test = new LeftRotateString();
        String str = test.LeftRotateString("abcXYZdef",3);
        System.out.println(str);
    }

}
