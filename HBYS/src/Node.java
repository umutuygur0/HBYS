//-----------------------------------------------------
// Title: Node class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class represents a generic node for use in various data structures
//              such as linked lists, trees, or queues.
//-----------------------------------------------------
public class Node<T> {

    //getters and setters
    public T getData() {//getter and setters
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    T data;

    public int getElement() {//getter and setters
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    int element;

    public Node<T> getPre() {//getter and setters
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    Node<T> pre ,next;

    public Node(T data){
        this.data=data;
        this.pre=null;
        this.next=null;
    }
    // constructor
    // Precondition: data is a valid object of type T.
    // Postcondition: A Node object is created with the specified data.

    public Node(int element,Node<T>pre,Node<T>next){
        this.element=element;
        this.pre=pre;
        this.next=next;
    }

}
