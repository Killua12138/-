package jianzhi;

public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0)
            return 0;
        int N = array.length;
        int index1 = binSearch(array, 0, N - 1, k), index2 = binSearch(array, 0, N - 1, k + 1);
        int count = index2 - index1;
        if (array[index2] == k)
            count++;
        return count;
    }

    private int binSearch(int[] array, int lo, int hi, int k) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
               if (array[mid] < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] argv) {
        GetNumberOfK test = new GetNumberOfK();
        int[] a = {1,2,3,3,3,5};
        test.GetNumberOfK(a, 3);
    }

}
