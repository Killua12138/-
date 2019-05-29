package jianzhi;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length == 0 || size == 0)
            return res;
        int N = num.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int begin = i - size + 1;
            while (!q.isEmpty() && begin > q.peekFirst())
                q.pollFirst();
            while (!q.isEmpty() && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            System.out.println(q);
            if (begin >= 0) {
                int index = q.peekFirst();
                res.add(num[index]);
            }
        }
        return res;
    }

    public static void main(String[] argv) {
        MaxInWindows test = new MaxInWindows();
        System.out.println(test.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }

}
