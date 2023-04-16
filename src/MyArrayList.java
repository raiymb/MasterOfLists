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
    public void clear() {
        for (int i = 0; i < size; i++) {
            realArray[i] = null;
        }
        size = 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) realArray[j]).compareTo((T) realArray[j + 1]) > 0) {
                    T temp = (T) realArray[j];
                    realArray[j] = realArray[j + 1];
                    realArray[j + 1] = temp;
                }
            }
        }
    }
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (realArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(realArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (realArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(realArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == realArray.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            realArray[i] = realArray[i-1];
        }
        realArray[index] = item;
        size++;
    }
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) realArray[index];
        System.arraycopy(realArray, index + 1, realArray, index, size - index - 1);
        realArray[--size] = null;
        return removedElement;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (item == realArray[i] || (item != null && item.equals(realArray[i]))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (realArray[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(realArray[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
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

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
