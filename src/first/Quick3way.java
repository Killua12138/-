package first;

import util.Sort;

/**
 * 分成3部分，维护2个指针，[lo,lt-1]元素小于v，[gt + 1,hi]元素大于v，[lt,i - 1]等于v，[i,gt]未确定
 * 荷兰国旗
 * @param <T>
 */
public class Quick3way <T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        sort(nums,0,nums.length - 1);
    }
    public void sort(T[] nums,int lo,int hi){
        if (hi <= lo)
            return;
        int lt = lo,i = lo + 1,gt = hi;
        T v = nums[lo];
        while (i <= gt){
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) swap(nums,lt++,i++);
            //[gt+1,hi]大于[i,gt]未确定
            else if (cmp > 0) swap(nums,i,gt--);
            else i++;
        }
        sort(nums,lo,lt - 1);
        sort(nums,gt + 1,hi);
    }
}
