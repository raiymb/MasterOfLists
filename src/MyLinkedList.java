import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        private final T data;
        private MyNode next;
        private MyNode prev;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head; // entry point
    private MyNode tail; // exit point
    private int length;

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        length++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // O(N)
    @Override
    public T get(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();
        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    @Override
    public boolean remove(T item) {
        MyNode temp = head;
        while (temp != null && !temp.data.equals(item)) {
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        } else if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        length--;
        return true;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();
        MyNode newNode = new MyNode(item);
        if (index == length) {
            add(item);
            return;
        }
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            length++;
            return;
        }

        MyNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        length++;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        MyNode temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        int index = length - 1;
        MyNode temp = tail;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.prev;
            index--;
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();
        MyNode nodeToRemove;
        if (index == 0) {
            nodeToRemove = head;
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (index == length - 1) {
            nodeToRemove = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            MyNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            nodeToRemove = temp.next;
            temp.next = temp.next.next;
            temp.next.prev = temp;
        }
        length--;
        return nodeToRemove.data;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {
        MyNode cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T data = cursor.data;
            cursor = cursor.next;
            return data;
        }
    }

}