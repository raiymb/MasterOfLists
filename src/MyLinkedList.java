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
}