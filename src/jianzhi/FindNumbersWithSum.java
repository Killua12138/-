package jianzhi;


import java.util.ArrayList;
import java.util.Collections;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int N = array.length - 1;
        int lo = 0,hi = N;
        while (lo < hi){
            int cursum = array[lo] + array[hi];
            if(cursum < sum)
                lo++;
            else if (cursum > sum)
                hi--;
            else{
                ArrayList<Integer> res = new ArrayList<>();
                res.add(array[lo]);
                res.add(array[hi]);
                return res;
            }
        }
        return new ArrayList<>();
    }
}
