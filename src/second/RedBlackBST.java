package second;

public class RedBlackBST<Key extends Comparable<Key>,Value> extends BST<Key,Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node node){
        if (node == null)
            return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        x.N = node.N;
        node.N = size(node.left) + size(node.right) + 1;
        return x;
    }

    private Node rotateRight(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        x.N = node.N;
        node.N = size(node.right) + size(node.left) + 1;
        return x;
    }

    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node node,Key key,Value value){
        if (node == null)
            return new Node(key,value,1,RED);
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            node.val = value;
        else if (cmp < 0)
            node.left = put(node.left,key,value);
        else
            node.right = put(node.right,key,value);
        if(isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left)&& (isRed(node.left.left)))
            node = rotateLeft(node);
        if (isRed(node.left)&&isRed(node.right))
            flipColors(node);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
}
