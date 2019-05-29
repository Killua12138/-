package leetcode;

public class Reverse {
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            int pop = x % 10;
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE && pop > 7)) return 0;
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            num = num * 10 + pop;
        }
        return num;
    }
}
