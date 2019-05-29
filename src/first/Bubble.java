package first;

import util.Sort;

import java.util.List;
import java.util.Set;

/**
 * 冒泡排序，从左往右，逆序就交换两个值，最大值自然而然的到了最左侧，如果某一趟没有发生交换就代表有序
 * @param <T>
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] nums){
        boolean hasSort = false;
        for (int i = nums.length - 1; i > 0 && !hasSort ; i--){
            hasSort = true;
            for (int j = 0; j < i; j++){
                if (less(nums[j+1],nums[j])){
                    hasSort = false;
                    swap(nums,j,j+1);
                }
            }
        }
    }
}
