package leetcode;

import java.util.*;

public class Merge {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0)
            return res;
        if (intervals.size() == 1){
            res.add(intervals.get(0));
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return (o1.start < o2.start) ? -1 : (o1.start == o2.start) ? 0 : 1;
            }
        });
        System.out.println(intervals);
        Interval temp = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval temp1 = intervals.get(i);
            if (temp.start<=temp1.start&&temp1.start<=temp.end)
                temp.end = Math.max(temp1.end,temp.end);
            else{
                res.add(new Interval(temp.start,temp.end));
                temp = temp1;
            }
        }
        res.add(temp);
        return res;
    }
    public static void main(String[] argv){
        Merge test = new Merge();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        System.out.println(test.merge(list));
    }

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return start+" "+end;
    }
}
