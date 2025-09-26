import java.util.List;
import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    //first refers to the first node in the list
    //if the list is empty, first will be null
    private Node first;
                    

    /**
        Constructs an empty linked list.
    */
   public LinkedList(){
    this.first = null;
   }

    



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
public Object getfirst(){
    if (this.first==null)
        throw new NoSuchElementException();

    return this.first;
}



    /**
        Removes the first element in the linked list.
        @return the removed element
    */

public Object removeFirst(){
    if (this.first==null)
        throw new NoSuchElementException();

    Object element = this.first.data;
    this.first = this.first.next;
    return element;
}



    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
public void addFirst(Object element){
    Node newNode = new Node();
    newNode.data = element;
    newNode.next = this.first;
    this.first = newNode;
}




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
public ListIterator listIterator()
{
    return new LinkedListIterator();
}




    //Class Node
    // Node is static because it dpes mpt need tp access amything in the linkedlist
    //The  object will store information not interact
    static class Node {
        public Node next;
        public Object data;
    }


    class LinkedListIterator implements ListIterator
    {
      //private data
      private Node position;
      private Node previous;
      private boolean isafterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
    public LinkedListIterator(){
        position = null;
        previous = null;
        isafterNext = false;
    }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
    public Object next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        previous = position;
        if (position == null){
            position = first;
        } else {
            position = position.next;
        }
        isafterNext = true;
        return position.data;
    }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
 public boolean hasNext(){
    //check if list is empty
    if (position == null){
        return first != null;
    }
    //the iterator has moved so check the next node
    return position.next != null;
 }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */

public void add(Object element){
    //check if iterator at beginning of the list
    if (position == null){
        addFirst(element);
        position = first;
    }

    else{
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = position.next;

        position.next = newNode;
        position = newNode;
    }
    isafterNext = false;
}




        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */

public void remove(){
    if(!isafterNext){
        throw new IllegalStateException();
    }
    if (position == first){
        removeFirst();
        position = null;
    } else {
        previous.next = position.next;
        position = previous;
    }
    isafterNext = false;
}






        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */

public void set(Object element){
    if (!isafterNext){
        throw new IllegalStateException();
    }
    position.data = element;
    //we dont have to change isafterNext because the structure of the list hasnt changed 
}

public String toString(){
    ListIterator iterator = listIterator();
    String result = "[";
    while (iterator.hasNext()){
        Object element = iterator.next();
        result += element;
        if (iterator.hasNext()){
            result += ", ";
        }
    }
    result += "]";
    return result;
    }//LinkedListIterator
}//LinkedList
}