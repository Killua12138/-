package leetcode;

public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 0 || s.length() <= numRows)
            return s;
        int add = numRows < 3 ? numRows + 1 : (numRows - 1) * 2;
        int num = add;
        int count = 0;
        char[] str = new char[100];
        for (int i = 0; i < numRows; i++) {
            add = i * 2;
            for (int j = i; j < s.length(); j += add) {
                str[count++] = s.charAt(j);
                add = (i == 0 || i == numRows - 1)? num : (num - add);
            }
        }
        return new String(str);
    }
    public static void main(String[] argv){
        Convert test = new Convert();
        System.out.println(test.convert("PAYPALISHIRING",4));
    }
}
