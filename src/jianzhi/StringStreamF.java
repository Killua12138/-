package jianzhi;

public class StringStreamF {
    int[] index = new int[256];
    int[] count = new int[256];
    int rank = 0;

    public void Insert(char ch) {
        if (index[ch] == 0)
            index[ch] = rank++;
        count[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char res = '#';
        int rank_now = 257;
        for (int i = 0; i < 256; i++){
            int rank_i = index[i];
            if (count[i] == 1){
                if (rank_i < rank_now){
                    rank_now = rank_i;
                    res = (char) i;
                }
            }
        }
        return res;
    }
}
