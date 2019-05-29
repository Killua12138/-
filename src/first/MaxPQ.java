package first;

import util.Sort;

public class MaxPQ<T extends Comparable<T>> extends Sort<T> {
    private T[] heap;

    private int N;

    public MaxPQ(int maxN) {
        heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    public void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = heap[i];
    }

    //上浮，子节点变动大于于父节点
    public void swinm(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    //父节点变动小于子节点，和子节点中的较大者交换
    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            swap(k,j);
            k = j;
        }
    }
    //堆大小加1，插入数组末尾，上浮;
    public void insert(T v){
        heap[++N] = v;
        swinm(N);
    }
    //交换头尾，堆大小减1，下沉
    public T delMax(){
        //数组第一个元素不存储
        T max = heap[1];
        swap(1,N--);
        heap[N+1] = null;
        sink(1);
        return max;
    }
    @Override
    public void sort(T[] nums) {

    }
}
