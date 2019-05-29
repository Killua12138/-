package Monney;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;

public class Pontifex {
    protected LinkedList<Integer> deck;//扑克牌组
    protected int[] KeyStream;
    protected int length;

    public Pontifex(LinkedList<Integer> deck,int length) {
        this.deck = deck;
        this.length = length;
        KeyStream = new int[length];
    }

    /**
     * 索引index下沉n位
     *
     * @param index 指定索引
     * @param n     移动距离
     */
    public void moveN(int index, int n) {
        while (n-- != 0) {
            //索引到达尾部回头节点
            swap(index, (index + 1) % 28);
            index = (index + 1) % 28;
        }
    }

    /**
     * 返回数值Num的索引
     *
     * @param num
     * @return
     */
    public int searchIndex(int num) {
        return deck.indexOf(num);
    }

    /**
     * 删除链表指定区间元素，并返回删除元素链表
     *
     * @param start
     * @param end
     * @return
     */
    public LinkedList<Integer> cutList(int start, int end) {
        LinkedList<Integer> newlist = new LinkedList<>();
        for (int i = start; i < end; i++) {
            newlist.add(deck.remove(start));
        }
        return newlist;
    }

    public void insertListHead(LinkedList<Integer> list) {
        deck.addAll(0, list);
    }

    public void insertListTail(LinkedList<Integer> list) {
        deck.addAll(deck.size(), list);
    }

    public void countCut() {
        int num = deck.getLast();
        LinkedList<Integer> headList = cutList(0, num);
        if (num < 27)
            deck.addAll(deck.size() - 1, headList);
    }

    public int[] getKeyStream() {
        int count = 0;
        while (count < length) {
            int indexOfJokerA = searchIndex(27);
            int indexOfJokerB = searchIndex(28);
            swap(indexOfJokerA, (indexOfJokerA + 1) % 28);
            moveN(indexOfJokerB, 2);
            indexOfJokerA = searchIndex(27);
            indexOfJokerB = searchIndex(28);
            int lo = Math.min(indexOfJokerA, indexOfJokerB);
            int hi = Math.max(indexOfJokerA, indexOfJokerB);
            LinkedList<Integer> head, tail;
            head = cutList(0, lo);
            tail = cutList(hi - head.size() + 1, deck.size());
            insertListHead(tail);
            insertListTail(head);
            countCut();
            int index = (deck.getFirst() == 28) ? 27: deck.getFirst();
            int num = deck.get(index);
            if (num < 27){
                KeyStream[count] = num;
                System.out.println(KeyStream[count]);
                count++;
            }
            System.out.println(count);
        }
        return KeyStream;
    }

    /**
     * 交换索引i,j的位置
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, temp);
    }

    public static void main(String[] argv) {
        /*LinkedList<Integer> list = new LinkedList<>();
        int[] a = {21, 16, 10, 9, 5, 1, 13, 14, 17, 22, 23, 4, 20, 28, 6, 2, 24, 19, 15, 27, 18, 26, 25, 11, 12, 7, 8, 3};
        for (int i : a)
            list.add(i);
        Pontifex test = new Pontifex(list, 10);
        test.getKeyStream();*/
    }

}
