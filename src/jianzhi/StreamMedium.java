package jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedium {
    private int count = 0;
    PriorityQueue<Integer> max = new PriorityQueue<>();
    PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            max.offer(num);
            count++;
            min.offer(max.poll());
        }
        else{
            min.offer(num);
            count++;
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 == 0){
            return (min.peek() + max.peek())/2.0;
        }
        else{
            return new Double(min.peek());
        }
    }
}
