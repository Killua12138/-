package first;

import util.Sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序，选取lo作为切分元素，确定lo位置元素的位置index，即使左子数组都小于lo,右子数组都大于lo
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length - 1);
    }
    public void sort(T[] nums,int lo,int hi){
        if (lo >= hi)
            return;
        int index = partition(nums,lo,hi);
        sort(nums,lo,index - 1);
        sort(nums,index + 1,hi);
    }
    private int partition (T[] nums,int lo,int hi){
        T v = nums[lo];
        int i = lo,j = hi + 1;
        while (true){
            while(less(nums[++i],v)) if (i == hi) break;
            while(less(v,nums[--j])) if (j == lo) break;
            if (i >= j)
                break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }
    private void shuffle(T[] nums){
        List<T> list =  Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}
