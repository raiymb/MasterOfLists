public interface MyList<T> extends Iterable<T> {
    void add(T item); // This method adds an item to the end of the list
    void add(T item, int index); // This method adds an item at the specified index in the list
    T get(int index); // This method returns the item at the specified index in the list
    T remove(int index); // This method removes the item at the specified index in the list
    boolean remove(T index); // This method removes the first occurrence of the specified item in the list
    void clear(); // This method removes all from lsit
    int size(); // This method returns the number of elements in the list
    boolean contains(Object o); // This method returns true if the list contains the specified element,
    // and false otherwise
    int lastIndexOf(Object o); // This method returns the last index of the specified element in the list,
    // or -1 if it is not present
    int indexOf(Object o); // This method returns the first index of the specified element in the list,
    // or -1 if it is not present
    void sort(); // This method sorts the list in ascending order
    String toString(); // This method returns a string representation of the list
}
