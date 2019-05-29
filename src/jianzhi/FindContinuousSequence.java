package jianzhi;

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 1,end = 2;
        int cursum = 3;
        while (start < end){
            if (cursum < sum){
                end++;
                cursum += end;
            }
            else if (cursum > sum){
                cursum -= start;
                start++;
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++){
                    list.add(i);
                }
                res.add(list);
                cursum -= start;
                start++;
            }
        }
        return res;
    }
}
