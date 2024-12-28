//-----------------------------------------------------
// Title: Queue class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class implements a simple generic queue structure
//              using linked nodes.
//-----------------------------------------------------
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Queue <T> implements Iterable<T>{
    //FIFO
    private Node<T> front, back;
    private int size;
    T data;

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = front;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }
    public boolean isEmpty()
    // checks if the queue is empty
    {
        return size == 0;
    }

    public Queue(){
        //constructor
        this.front=null;
        this.back=null;
        this.size=0;

    }
    //--------------------------------------------------------
    // Summary: Adds an element to the rear of the queue.
    // Precondition: data is a valid object of type T.
    // Postcondition: The element is added to the queue.
    //--------------------------------------------------------
    public void enqueue(T data){
        Node<T> n =new Node<>(data);
        if(isEmpty()){
            front=n;
        }else{back.next=n;}
        back=n;
        size++;
    }
    //--------------------------------------------------------
    // Summary: Removes and returns the front element of the queue.
    // Postcondition: The front element is removed and returned.
    // Throws: RuntimeException if the queue is empty.
    //--------------------------------------------------------
    public T dequeue ()
    // removes data from the queue
    {
        if(isEmpty())
        {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null)
        {
            back = null;
        }
        size--;
        return data;
    }
    public T peek ()
    // displays the first data of the queue
    {
        if (isEmpty())
        {
            return null;
        }
        return back.data;
    }
    public int size()
    // returns the queues current size
    {
        return size;
    }

}
