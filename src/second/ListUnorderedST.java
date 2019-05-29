package second;

public class ListUnorderedST<Key,Value> implements UnorderedST<Key,Value>{
    private Node first;
    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    @Override
    public int size() {
        int count = 0;
        Node cur = first;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public Value get(Key key) {
        Node cur = first;
        while (cur != null){
            if (cur.key.equals(key))
                return cur.value;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        Node cur = first;
        while (cur != null){
            if (cur.key.equals(key)){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        //头插法；
        first = new Node (key,value,first);
        return;
    }

    //No-Check
    @Override
    public void delete(Key key) {
        if (first == null)
            return;
        if (first.key.equals(key)){
            first = first.next;
            return;
        }
        Node pre = first;
        Node cur = first;
        while (cur != null){
            if (cur.key.equals(key)){
                pre.next = cur.next;
                cur = null;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}
