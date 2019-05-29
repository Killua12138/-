package first;

import util.Sort;

/**
 * 插入排序，左侧有序，交换相邻元素，使逆序减1，交换次数取决于逆序对数，如果逆序就交换
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] nums){
        //索引i左侧始终有序，j插入i左侧中，和相邻元素比较如果逆序就交换
        for (int i = 1; i < nums.length; i++){
            for (int j = i; j > 0 && less(nums[j],nums[j - 1]); j --){
                swap(nums,j,j-1);
            }
        }
    }
}
