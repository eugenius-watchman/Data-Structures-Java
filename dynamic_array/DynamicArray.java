/**
 * A generic dynamic array implementation
 *
 * @author Eugene Darrah-Gblorkpor
 */

package eugenius.datastructures.dynamic_array;

@SuppressWarnings("unchecked")
public class DynamicArray <T> implements Iterable <T> {

    private T[] arr; // the actual array that stores the elements

//    @Override
//    public Iterator<T> iterator() {
//        return null;
//    }

    private int len = 0; // number of elements in the array / how many the user thinks are in it
    private int capacity = 0; // actual array size

    // constructors
    // create a dynamic array with initial capacity of 16 (default size)
    public DynamicArray() {

        this(16);
    }

    // check whether the given capacity is not negative
    // initialize the arr with the specified capacity
    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    // size and empty check
    public int size() {

        return len; // return number of items in the array
    }

    public boolean isEmpty() {

        return size() == 0; // returns true if the array has no items
    }

    // getters and setters methods
    public T get(int index) {

        return arr[index]; // fetch the item at a specific index
    }

    public void set(int index, T elt) {

        arr[index] = elt; // replaces the items at a specific position with a new value
    }

    // clear the array
    // removes all elts by setting each position to null and resetting the size len to 0
    public void clear() {
        for (int i = 0; i < capacity; i++)
            arr[i] = null;
        len = 0;
    }

    // add an elt
    // checks for enough space. if not, it doubles the array size
    // copy existing elts into a new, (larger array)
    // adds the new elt at the end of the array
    public void add(T elt) {
        // resizing
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1; // if cap is 0, we set cap to 1...so we can add items
            else capacity *= 2; // we double the size of array
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++)
                new_arr[i] = arr[i];
            arr = new_arr; // extra nulls added to arr
        }

        arr[len++] = elt;
    }

    // remove a specific element at a specific index in the list
    // checks if index is valid
    // removes the elt and shifts all elts after it
    // decreases the size(len) and updates the capacity
//    public T removeAt(int rm_index) {
//        if (rm_index >= len || rm_index < 0) throw new IndexOutOfBoundsException();
//        T data = arr[rm_index];
//        T[] new_arr = (T[]) new Object[len - 1];
//        for (int i = 0, j = 0; i < len; i++, j++)
//            if (i == rm_index) j--; // skipping over rm_index... and fixing j temporarily
//            else new_arr[j] = arr[i];
//        arr = new_arr;
//        capacity = --len;
//        return data;
//    }

    public T removeAt(int rm_index) {
        if (rm_index >= len || rm_index < 0)
            throw new IndexOutOfBoundsException();

        T data = arr[rm_index]; // Save the item to be removed

        // Shift elements to the left, overwriting the item at rm_index
        for (int i = rm_index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[--len] = null; // Reduce the length and clear the last element
        return data; // Return the removed item
    }


    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++)
            if (arr[i].equals(obj))
                return 1;
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    // iterator is still fast but not as fast as iterative for loop
    // allow the use of for-each loops with dynamic array
    // the hasNext method checks if there are more items
    // the next method returns the current item and moves to the next one
    @Override public java.util.Iterator <T> iterator () {
        return new java.util.Iterator <T> () {
            int index = 0;
            public boolean hasNext() {

                return index < len;
            }
            public T next() {

                return arr[index++];
            }
        };
    }

    // string representation
    // converts the array to a readable string format, like [1, 2, 3]
    // uses stringBuilder to efficiently build the string
    @Override public String toString(){
        if (len == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder( len ).append("[");
            for (int i = 0; i < len - 1; i++)
                sb.append(arr[i] + ", ");
            return sb.append(arr[len-1] + "]").toString();
        }
    }

}
