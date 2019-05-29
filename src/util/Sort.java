package util;

public abstract class Sort<T extends Comparable> {
    public abstract void sort(T[] nums);

    public boolean less(T v,T w){
        return v.compareTo(w) < 0;
    }

    public void swap(T[] a,int i,int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
