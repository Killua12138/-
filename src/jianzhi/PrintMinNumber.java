package jianzhi;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        int n = numbers.length;
        if (n == 0)
            return new String("");
        String[] strs = new String[n];
        for (int i = 0; i < n; i++){
            strs[i] = numbers[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String str = "";
        for (String i : strs)
            str += i;
        System.out.println(str);
        return str;
    }
    public static void main(String[] argv){
        PrintMinNumber test = new PrintMinNumber();
        test.PrintMinNumber(new int[]{3,32,321});
    }

}
