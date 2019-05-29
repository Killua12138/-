package first;

public class UF1 {
    private int[] id;
    private int N;

    public UF1(int N) {
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int root(int i){
        while (id[i] != i) i = id[i];
        return i;
    }

    public boolean connected(int p,int q){
        return root(p) == root(q);
    }

    public void union(int p,int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
