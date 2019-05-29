package first;

import util.Sort;

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
        sort(nums,0,nums.length);
    }
    public void sort(T[] nums,int lo,int hi){
        if (hi <= lo + 1)
            return;
        int j = partition(nums,lo,hi);
        sort(nums,j + 1,hi);
        sort(nums,lo,j);
    }
    private int partition(T nums[],int lo,int hi){
        int i = lo, j = hi;
        T v = nums[lo];
        while (true){
            //扫描左数组，出现nums[i]>v终止
            while (less(nums[++i],v) && i != hi - 1);
            //扫描左数组，出现nums[j]<v终止
            while (less(v,nums[--j]) && j != lo);
            if (i >= j ) break;
            //交换i,j
            swap(nums,i,j);
        }
        //指针相遇或i,j到达尽头，将lo和左子数组最右侧元素交换
        swap(nums,lo,j);
        return j;
    }
    private void shuffle(T[] nums){
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}
