package jianzhi;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] argv){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int temp = n;
        while (n % 10 == 0)
            n /= 10;
        int reverse = 0;
        while (n != 0){
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        System.out.println(reverse + temp);
    }
}
