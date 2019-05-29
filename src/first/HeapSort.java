package first;

import util.Sort;

/**
 * 堆排序
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        //构造最大元素的二叉堆,叶子节点不需要下沉操作可以忽略所以从N/2开始
        for (int k = N/2; k >=1;k--)
            sink(nums,k,N);
        //利用sink进行排序，交换头尾，头元素下沉
        while (N > 1){
            swap(nums,1,N--);
            sink(nums,1,N);
        }
    }
    public void sink(T[] nums,int k,int N){
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1)) j++;
            if (!less(nums, k, j)) break;
            swap(nums, k, j);
            k = j;
        }
    }

    public boolean less(T[] nums,int i,int j){
        return nums[i].compareTo(nums[j]) < 0;
    }
}
