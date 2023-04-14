import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private Object[] realArray;
    private int size;
    public MyArrayList(){
        this(5);
    }

    public MyArrayList(int start_size){
        if(start_size<0){
            throw new IllegalArgumentException("Size of array can't be negative");
        }
        this.realArray =new Object[start_size];
    }

    private void increaseCapacity(){
        int newCapacity = realArray.length*2;
        Object[] newArray =new Object[newCapacity];
        for(int i = 0; i< realArray.length; i++){
            newArray[i] = realArray[i];
        }
        realArray = newArray;
    }

    @Override
    public void add(T item) {
        if (size == realArray.length) {
            increaseCapacity();
        }
        realArray[size++] = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T)realArray[index];
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return (T)realArray[cursor++];
        }
    }
}
