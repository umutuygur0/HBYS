//-----------------------------------------------------
// Title: BSTREE class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class implements a Binary Search Tree (BST) structure
//              and provides functionality for adding, removing, and
//              traversing nodes.
//-----------------------------------------------------
public class BSTREE<Key extends Comparable<Key>,Value> {
    // Node class represents the individual elements of the BST
    //--------------------------------------------------------
    // Summary: A nested class to represent a node in the BST.
    // Fields: key (data of the node), left (left child), right (right child).
    //--------------------------------------------------------
    private Node root;//root of binary search tree
    int count=0;//members
    private class Node  {
        //private node class used to implement bst
        private Key key;
        private Value  val;
        private Node left, right;
        private int a;// # nodes in subtree rooted here
        public Node (Key  key,Value val, int a){
            this.key = key; this.val = val; this.a = a; }
    }
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.a;
    }
    // adds the root to  the get function
    public Value get(Key  key){return get(root,key);
    }
    // Return value associated with key in the subtree rooted at x;
    // return null if key not present in subtree rooted at x.
    private Value get (Node x, Key key){
        if (x==null)return  null;
        int cmp= key.compareTo(x.key);
        if (cmp>0)return get(x.right,key);
        else if(cmp<0 )return get(x.left,key);
        else return x.val;
    }
    // Search for key. Update value if found; grow table if new.
    public void  put(Key key, Value val)
    {
        root = put(root, key, val);
    }
    // Change key’s value to val if key in subtree rooted at x.
    // Otherwise, add new node to subtree associating key with val.
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val, 1);
        int cmp =  key.compareTo(x.key);
        if (cmp <  0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val  = val;
        x.a = size(x.left) + size(x.right) + 1;
        return x;
    }
    // adds the root to the min function
    public Key min()
    {
        return min(root).key;
    }
    // returns the minimum node of the binary search tree
    private Node  min(Node x)
    {
        if (x.left  == null) return x;
        return  min(x.left);
    }
    public Key floor  (Key key){// adds root to the floor function
        Node x=floor(root, key);
        if(x==null)return null;
        return x.key;
    }
    // returns the floor value of thec given node
    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp =   key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    // adds root to the select function
    public Key select(int k)
    {
        return select(root, k).key;
    }

    // Return Node containing key of rank k.
    private Node select(Node x, int k)
    {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return  select(x.left, k);
        else if (t < k)  return select(x.right, k-t-1);
        else return x;
    }

    // adds root to the rank function
    public int rank(Key  key)
    {
        return rank  (key, root);
    }
    // Return number of keys less than x.key in the subtree rooted at x.
    private int rank(Key key, Node x)
    {
          if (x == null) return 0;
         int cmp = key.compareTo(x.key);
         if (cmp < 0) return rank(key, x.left);
          else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
          else return size(x.left);
    }

    // adds root to the deleteMin function
    public void  deleteMin()
    {
        root = deleteMin(root);
    }

    // deletes the minimum value of the binary search tree
    private  Node deleteMin(Node x)
    {
        if  (x.left == null) return x.right;

        x.left = deleteMin(x.left);
        x.a = size(x.left) + size(x.right) + 1;
        return x;
    }
    // adds root to the delete function
    public void delete(Key key)
    {
        root = delete(root, key);
    }

    // deletes the specific node from the binary search tree
    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.a = size(x.left) + size(x.right) + 1;
        return x;
    }
    // iterator using queue
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node x, Queue<Key> queue) {
        if (x == null) return;
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

}
