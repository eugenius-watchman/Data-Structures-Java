/**
 * A generic dynamic array implementation
 *
 * @author Eugene Darrah-Gblorkpor
 */

package eugenius.datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList <T> implements  Iterable <T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

//    @Override
//    public Iterator<T> iterator() {
//        return null;
//    }

    // internal node class to represent data
    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // empty this linked list 0(n)
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    // return the size of this linked list
    public int size() {
        return size;
    }

    // check if linked list is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // add elt to the tail of linked list, 0(1)
    public void add(T elt) {
        addLast(elt);
    }

    // add elt to the beginning of this linked list, 0(1)
    public void addFirst(T elt) {

        //check for empty list
        if (isEmpty()) {
            head = tail = new Node<T>(elt, null, null);
        } else {
            head.prev = new Node<T>(elt, null, head);
            head = head.prev;
        }
        size++;
    }

    // add a node to the tail of the linked list, 0(1)
    public void addLast(T elt) {

        // check for empty list
        if (isEmpty()) {
            head = tail = new Node<T>(elt, null, null);
        } else {
            tail.next = new Node<T>(elt, tail, null);
        }
        size++;
    }

    // check value of first node if it exists, 0(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    // check value of last node if it exists, 0(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // remove the first value at the head of link list, 0(1)
    public T removeFirst() {

        // can't remove data from empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // extract data at the head and move the head pointer forwards by one node
        T data = head.data;
        head = head.next;
        --size;

        // if list is empty, set tail to null too
        if (isEmpty()) tail = null;

            // memory cleaning of previous node
        else head.prev = null;

        // return the data that was at the first node we had just removed
        return data;
    }

    // remove the first value at the tail of link list, 0(1)
    public T removeLast() {

        // can't remove data from empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        // extract data at the head and move the tail pointer forwards by one node
        T data = tail.data;
        tail = tail.prev;
        --size;

        // if list is empty, set head to null too
        if (isEmpty()) head = null;

            // memory cleaning of previous node that had just been removed
        else tail.next = null;

        // return the data that was at the last node we had just removed
        return data;
    }

    // remove arbitrary node from the linked list, 0(1)
    private T remove(Node<T> node) {

        // if node to be removed is somewhere at the head or tail, we handle them independently
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        // make pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // temporary store data to be run
        T data = node.data;

        // memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        // Return the data at the not that was just removed
        return data;
    }

    // remove node at a particular index, 0(n)
    public T removeAt(int index) {

        // make sure index provided is valid
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index " + index + " is out of bounds. Valid range: 0 to " + (size - 1));

        int i;
        Node<T> trav;

        // search from the front of list
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++)
                trav = trav.next;

            // search from the back of list
        } else
            for (i = size - 1, trav = tail; i != index; i--)
                trav = trav.prev;

        return remove(trav);
    }

    // remove a particular value in linked list, 0(n)
    public boolean remove(Object obj) {
        Node<T> trav = head;

        // searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // search for null obj
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals((trav.data))) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // find the index of a particular value in linked list, 0(n)
    public int indexOf(Object obj) {

        int index = 0;
        Node<T> trav = head;

        //support search for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next, index++)
                if (trav.data == null)
                    return index;

            // search for non null obj
        } else {
            for (trav = head; trav != null; trav = trav.next, index++)
                if (obj.equals(trav.data)) {
                    return index;
                }
            }
        return -1;
    }

    // check if a value is contained within linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override public java.util.Iterator<T> iterator () {
        return new java.util.Iterator <T> () {
            private Node <T> trav = head;
            @Override public boolean hasNext() {
                return trav != null;
            }

            @Override public T next () {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node <T> trav = head;
        while(trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

}