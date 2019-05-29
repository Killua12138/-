package jianzhi;

//快速幂
public class Power {
    public double Power(double base, int exponent) {
        int a = Math.abs(exponent);
        double ans = 1;
        while (a != 0) {
            if ((a & 1) != 0)
                ans *= base;
            base *= base;
            a = a >> 1;
        }
        return exponent < 0 ? 1 / ans : ans;
    }

    public static void main(String[] argv) {
        Power test = new Power();
        System.out.println(test.Power(2d, -3));
    }

}
