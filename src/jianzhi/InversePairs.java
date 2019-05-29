package jianzhi;

public class InversePairs {
    int[] ans;
    long count;

    public int InversePairs(int[] array) {
        if (array.length == 0)
            return 0;
        int N = array.length;
        count = 0;
        ans = new int[N];
        mergeSort(array, 0, N - 1);
        return (int) count%1000000007;
    }

    private void mergeSort(int[] array, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, hi);
    }

    private void merge(int[] array, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            ans[k] = array[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                array[k] = ans[j++];
            else if (j > hi)
                array[k] = ans[i++];
            else if (ans[i] >= ans[j]) {
                count = mid - i + count + 1;
                array[k] = ans[j++];
            } else {
                array[k] = ans[i++];
            }
        }
        count = count %1000000007;
    }

    public static void main(String[] argv) {
        InversePairs test = new InversePairs();
        test.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0});
        System.out.println(test.count);
    }

}
