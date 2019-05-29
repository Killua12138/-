package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k < 0)
            return new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int num : input){
            priorityQueue.add(num);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }
        return new ArrayList<>(priorityQueue);
    }

}
