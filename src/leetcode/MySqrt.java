package leetcode;

public class MySqrt {
    public int mySqrt(int x) {
        int l = 0, h = x;
        while (l <= h){
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid)
                return sqrt;
            if (sqrt < mid)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return h;
    }
    public static void main(String[] argv){
        MySqrt test = new MySqrt();
        int res = test.mySqrt(8);
        System.out.println(res);
    }

}
