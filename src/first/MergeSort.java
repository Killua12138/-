package first;

import util.Sort;

/**
 * 自顶向下
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums,0,nums.length - 1);
    }
    public void sort(T[] nums,int lo,int hi){
        if(hi - lo < 1)
            return;
        int mid = (lo + hi)/2;
        sort(nums,lo,mid);
        sort(nums,mid + 1,hi);
        merge(nums,lo,mid,hi);
    }
    /**
     * 原地归并先复制到辅助数组aux,然后分为左右部分，在辅助数组中依次比较，把归并结果放回原数组
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    protected void merge(T[] nums,int lo,int mid,int hi){
        int i = lo,j = mid + 1;
        for(int k = lo; k <= hi; k++)
            aux[k] = nums[k];
        for (int k = lo; k <= hi; k++){
            if (i > mid)
                nums[k] = aux[j++];
            else if (j > hi)
                nums[k] = aux[i++];
            else if (less(aux[j],aux[i]))
                nums[k] = aux[j++];
            else
                nums[k] = aux[i++];
        }
    }
}
