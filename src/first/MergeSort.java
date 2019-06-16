package first;

import util.Sort;

/**
 * 自顶向下
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums,0,nums.length);
    }
    public void sort(T[] nums,int lo,int hi){
        if (hi <= lo + 1)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(nums,lo,mid);
        sort(nums,mid,hi);
        merge(nums,lo,mid,hi);
    }
    /**
     * 原地归并先复制到辅助数组aux,然后分为左右部分，在辅助数组中依次比较，把归并结果放回原数组
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    public void merge(T[] nums,int lo,int mid,int hi){
        if (less(nums[mid - 1],nums[mid]))
            return;;
        int i = lo,j  = mid;
        for (int k = lo; k < hi; k++)
            aux[k] = nums[k];
        for (int k = lo; k < hi; k++){
            if (i >= mid) nums[k] = aux[j++];
            else if (j >= hi) nums[k] = aux[i++];
            else
                nums[k] = less(aux[i],aux[j]) ? aux[i++] : aux[j++];
        }
    }

}
