package leetcode;

public class LongestPalindrome {

    public String LongestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int n = s.length();
        int max = 0, start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCente(i, i, s);
            int len2 = expandAroundCente(i, i + 1, s);
            if (max < Math.max(len1, len2)) {
                max = Math.max(len1, len2);
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    private int expandAroundCente(int start, int end, String s) {
        int i = start, j = end;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        System.out.println(i+" "+j);
        return j - i - 1;
    }
    public static void main(String[] argv){
        LongestPalindrome test = new LongestPalindrome();
        String str = test.LongestPalindrome("babad");
        System.out.println(str);
    }
}
