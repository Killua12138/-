package leetcode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2 = nums2.length;
        int sum = l1 + l2;
        if (sum % 2 != 0)
            return getKthMin(sum / 2 + 1,nums1,nums2,0,0);
        else
            return (getKthMin(sum / 2,nums1,nums2,0,0) +
                    getKthMin(sum / 2 + 1,nums1,nums2,0,0)) / 2.0;
    }
    private double getKthMin(int k,int[] num1,int[] num2,int s1,int s2){
        if (s1 >= num1.length)
            return num2[s2 + k - 1];
        if (s2 >= num2.length)
            return num1[s1 + k - 1];
        if (k == 1)
            return Math.min(num1[s1],num2[s2]);
        int mid = k / 2 - 1;
        mid = Math.min(mid,num1.length - s1 - 1);
        mid = Math.min(mid,num2.length - s2 - 1);
        if (num1[mid + s1] >= num2[mid + s2])
            return getKthMin(k - mid - 1,num1,num2,s1,s2 + mid + 1);
        else
            return getKthMin(k - mid - 1,num1,num2,s1 + mid + 1,s2);
    }
    public static void main(String[] argv){
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,3,4,5,6};
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        double res = test.findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }

}
