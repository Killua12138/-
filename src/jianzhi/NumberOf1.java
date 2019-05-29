package jianzhi;

public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0,max = (int)Math.log(Double.valueOf(n));
        int m = 1;
        System.out.println(max);
        for (int i = 0; i < max + 2;i++){
            count = ((n & m) == 0) ? count : count + 1;
            m = m << 1;
        }
        return count;
    }
    public static void main(String[] argv){
        NumberOf1 test = new NumberOf1();
        test.NumberOf1(16);
    }

}
