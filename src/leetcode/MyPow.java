package leetcode;


public class MyPow {
    public double myPow(double x, int n) {
        double ans = 1;
        double base = x;
        long y = n;
        long k = (y < 0) ? -y : y;
        while (k != 0) {
            if ((k & 1) != 0)
                ans *= base;
            base *= base;
            k >>= 1;
        }
        return (n < 0) ? 1 / ans : ans;
    }

    public static void main(String[] argv) {
        System.out.println(Integer.MAX_VALUE);
        MyPow test = new MyPow();
        double res = test.myPow(2, -2147483648);
        System.out.println(res);
    }

}
