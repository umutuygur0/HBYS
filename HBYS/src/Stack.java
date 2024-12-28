//-----------------------------------------------------
// Title: Stack class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class implements a simple generic stack structure
//              using linked nodes.
//-----------------------------------------------------
public class Stack <T> {
    //lifo
    Node <T> first;
    int size;
    public Stack(){
        this.first=first;
        this.size=0;
    }
    public boolean isEmpty()
    // checks if the stack is empty
    {
        return size == 0;
    }
    //--------------------------------------------------------
    // Summary: Pushes an element onto the stack.
    // Precondition: data is a valid object of type T.
    // Postcondition: The element is added to the top of the stack.
    //--------------------------------------------------------
    public void push(T data){
        Node<T> n= new Node<>(data);
        n.next=first;
        first=n;
        size++;
    }
    //--------------------------------------------------------
    // Summary: Removes and returns the top element of the stack.
    // Postcondition: The top element is removed and returned.
    // Throws: RuntimeException if the stack is empty.
    //--------------------------------------------------------
    public T pop(){
        if(isEmpty()){return null;}
        T data = first.data;
        first=first.next;
        size--;
        return data;
    }

    public T peek(){
        if(isEmpty()){return null;}
        return first.data;
    }
    public int size(){
        return size;
    }


}
