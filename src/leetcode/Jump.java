package leetcode;

import java.util.Arrays;

public class Jump {
    public int jump(int[] nums) {
        int count = 0,N = nums.length;
        int index = 0;
        while (index < N - 1){
            int max = 0,next = 0;
            if (nums[index] + index >= N - 1)
                return ++count;
            for (int i = index + 1; i <= index + nums[index] && i < N; i++){
               if (max <= i + nums[i]){
                   max = i + nums[i];
                   next = i;
               }
           }
           index = next;
           count++;
        }
        return count;
    }
    public static void main(String[] argv){
        Jump test = new Jump();
        int[] a = new int[]{2,3,1,1,4};
        System.out.println(test.jump(a));
    }

}
