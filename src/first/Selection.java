package first;


import util.Sort;
import util.TestSort;

/**
 * 选择排序，每次从剩下的元素中选取最小的和索引交换，索引i右移，每一趟确定一个位置
 * @param <T>
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] nums){
        for (int i = 0; i < nums.length; i++){
            int min = i;
            for (int j = i; j < nums.length; j++){
                if (less(nums[j],nums[min]))
                    min = j;
            }
            swap(nums,i,min);
        }
    }
}
