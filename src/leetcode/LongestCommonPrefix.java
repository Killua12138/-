package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int index = 0;
        String str = strs[0];
        for (int i = 1; i < strs.length; i++){
            index = 0;
            String str1 = strs[i];
            int m = 0;
            while (m < str.length() && m < str1.length() && str.charAt(m) == str1.charAt(m)){
                    index++;
                    m++;
            }
            str = str.substring(0,index);
        }
        return str;
    }
    public static void main(String[] argv){
        String s = "asdafsfg";
        System.out.println(s.substring(0,1));
    }

}
