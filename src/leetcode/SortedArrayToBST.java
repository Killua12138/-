package leetcode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return subArrayTree(nums,0,nums.length);
    }
    private TreeNode subArrayTree(int[] nums,int start,int end){
        if (start >= end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = subArrayTree(nums,start,mid);
        root.right = subArrayTree(nums,mid + 1,end);
        return root;
    }
}
