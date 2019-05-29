package util;

public class Caesar {
    /**
     *
     * @param str 加密字符串
     * @param offset 解密偏移量
     * @return
     */
    public static String deciphering(String str, int offset) {
        str = str.toLowerCase();
        char[] newstr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                newstr[i] = (char) ('a' + (c - offset - 'a') % 26);
            else
                newstr[i] = str.charAt(i);
        }
        return String.valueOf(newstr);
    }

    public static void main(String[] argv) {
        System.out.println(deciphering("VSRQJHEREVTXDUHSDQWU(V)", 3));
        //结果spongebobsquarepantr(s)
    }
}
