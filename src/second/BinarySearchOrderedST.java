package second;


import first.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchOrderedST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchOrderedST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Comparable[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        if (index < N && keys[index].compareTo(key) == 0){
            values[index] = value;
            return;
        }
        for (int j = N; j > index; j--){
            keys[j] = keys[j - 1];
            values[j] = values[j-1];
        }
        keys[index] = key;
        values[index] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (size() == 0)
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return values[i];
        else
            return null;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    //小于key的个数,二分查找找出key的位置或插入位置
    @Override
    public int rank(Key key) {
        int l = 0, h = N - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            Key temp = keys[mid];
            if (temp.compareTo(key)==0)
                return mid;
            if (temp.compareTo(key) < 0)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return l;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        int index = rank(l);
        List<Key> list = new ArrayList<>();
        while(keys[index].compareTo(h) <= 0){
            list.add(keys[index]);
            index++;
        }
        return list;
    }
}
