package jianzhi;

public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int m = 1; m <= n; m = m * 10){
            int a= n/m,b = n % m;
            count = (a+8)/10*m + ((a % 10) ==1 ? b + 1 : 0) + count;
        }
        return count;
    }
}
