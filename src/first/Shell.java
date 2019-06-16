package first;

import util.Sort;

/**
 * 希尔排序，对间隔为h的数的进行插入排序，每次减少的逆序对大于等于1，不断减小h直到1,最后数组有序
 * @param <T>
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i;j >= h && less(nums[j],nums[j - h]); j-= h)
                    swap(nums,j,j - h);
            }
            h = h / 3;
        }
    }
}
