public interface MyList<T> extends Iterable<T> {
    void add(T item);
    T get(int index);
    T remove(int index);
    int size();
}
