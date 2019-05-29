package second;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> {
    protected Node root;

    protected class Node {
        protected Key key;
        protected Value val;
        protected Node left;
        protected Node right;
        protected boolean color;
        protected int N;

        public Node(Key key, Value val,int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

        public Node(Key key, Value val,int N,boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }
    public int size(){
        return size(root);
    }
    public int size(Node node){
        if (node == null)
            return 0;
        return node.N;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node node,Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left,key);
        else if (cmp > 0)
            return get(node.right,node.key);
        else return node.val;
    }
    public void put(Key key,Value value){
        root=put(root,key,value);
    }
    private Node put(Node node,Key key,Value value){
        if (node == null)
            return new Node(key,value,1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left,key,value);
        else if (cmp > 0)
            node.right = put(node.right,key,value);
        else
            node.val = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node node){
        if (node.left == null)
            return node;
        return min(node.left);
    }
    public Key floor(Key key){
        return floor(root,key).key;
    }
    private Node floor(Node node,Key key){
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left,key);
        Node t = floor(node.right,key);
        if (t != null) return t;
        else return node;
    }
    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node node,int k){
        if (node == null)
            return null;
        int t = size(node.left);
        if (t == k)
            return node;
        else if (t > k)
            return select(node.left,k);
        else
            return select(node,k-t-1);
    }
    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node node,Key key){
        if(node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node.left,key);
        else if(cmp > 0)
            return rank(node.right,key)+1+size(node.left);
        else
            return size(node.left);
    }
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node node){
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return  node;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node node,Key key){
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = delete(node.left,key);
        else if (cmp > 0)
            node.right = delete(node.right,key);
        else{
            //单节点情况
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node t = node;
            node = min(t.right);
            node.left = t.left;
            node.right = deleteMin(t.right);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    public List<Key> keys(Key lo,Key hi){
        return keys(root,lo,hi);
    }
    private List<Key> keys(Node node,Key lo,Key hi){
        List<Key> list = new ArrayList<>();
        if (node == null)
            return list;
        int cmpl = lo.compareTo(node.key);
        int cmph = hi.compareTo(node.key);
        if (cmpl < 0)
            list.addAll(keys(node.left,lo,hi));
        if (cmpl <= 0 && cmph >= 0)
            list.add(node.key);
        if (cmph > 0)
            list.addAll(keys(node.right,lo,hi));
        return list;
    }
    public static void main(String[] argv){
        BST<Integer,Integer> bst = new BST();
        for(int i = 0; i < 13; i++){
            bst.put(i,i);
        }
        bst.deleteMin();
        bst.delete(4);
        List<Integer> list = bst.keys(0,12);
        System.out.println(list);
    }
}
