package first;

public class UF {
    private int[] id;
    private int N;

    public UF(int n) {
        this.N = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < N; i++) {
            if (id[i] == qid)
                id[i] = pid;
        }
    }
}
