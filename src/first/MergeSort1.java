package first;

import util.Sort;
/**
 * 自底向上排序
 **/
public class MergeSort1<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        for (int sz = 1; sz < nums.length; sz += sz) {
            for (int i = 0; i < nums.length - sz; i += 2 * sz) {
                merge(nums, i, i + sz, Math.min(i + sz + sz, nums.length));
            }
        }
    }
}
