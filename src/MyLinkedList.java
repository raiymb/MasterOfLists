import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        private final T data; // The data stored in the node
        private MyNode next; // The next node in the list
        private MyNode prev; // The previous node in the list

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head; // entry point
    private MyNode tail; // exit point
    private int length; // The number of nodes in the list

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item); // Create a new node with the given item
        length++;
        // If the list is empty, set the head and tail to the new node
        if (head == null) {
            head = tail = newNode; // Set both head and tail to the new node
            return;
        }
        // Otherwise, add the new node to the end of the list
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MyNode current = head;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
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
    public boolean contains(Object o) {
        MyNode current = head;
        while (current != null) {
            if ((current.data == null && o == null) || (current.data != null && current.data.equals(o))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /*
    This method is an implementation of the Bubble Sort algorithm for sorting a linked list.
    If the linked list is null or contains only one element, it returns without sorting.
    It uses the Comparable interface to compare elements for sorting.
     */
    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        MyNode current;
        MyNode previous = null;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                // Compare the current node and the next node and swap them if necessary
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    MyNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;

                    // Update the previous node's next pointer to point to the swapped node
                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }

                    previous = temp;
                    swapped = true;
                } else {
                    // If no swapping occurred, move the current and previous pointers forward
                    previous = current;
                    current = current.next;
                }
            }
            tail = previous;  // Update the tail pointer to the last node after each iteration
        } while (swapped);  // Continue iterating until no swapping occurs
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