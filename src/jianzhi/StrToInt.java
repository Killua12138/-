package jianzhi;

public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int sign = 1;
        long num = 0;
        if (str.charAt(0) == '-')
            sign = -1;
        else if (str.charAt(0) == '+')
            sign = 1;
        else if (!isNum(str.charAt(0)))
            return 0;
        else if (isNum(str.charAt(0)))
            num = num * 10 + (str.charAt(0) - '0');

        for (int i = 1; i < str.length(); i++) {
            if (!isNum(str.charAt(i)))
                return 0;
            num = num * 10 + (str.charAt(i) - '0');
        }
        return (int)(num * sign);
    }

    public boolean isNum(char c) {
        if (c < '0' || c > '9')
            return false;
        return true;
    }
    public static void main(String[] argv){
        StrToInt test = new StrToInt();
        String str = "123";
        System.out.println(test.StrToInt(str));
    }

}
