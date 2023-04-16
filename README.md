# MyArrayList and MyLinkedList
Batyr Raiymbek
Group: SE-2202

# Overview

The project is a Java implementation of the data structures MyArrayList and MyLinkedList. Each of these data structures is a list of items stored in memory. MyArrayList is a dynamic array, and MyLinkedList is a linked list.

Each data structure implements methods to add an item, delete an item, retrieve an item by index, delete an item by value, clean up a list, find an item in the list, find the index of the last occurrence of an item, find the index of the first occurrence of an item, and sort the list.

The MyList interface is a Java interface that defines a set of methods for working with a list of elements. It is not an implementation of a list itself, but rather a blueprint or contract that defines the methods that any implementation of a list should have.

# Usage
Both classes implement the List interface, and have the following methods:

**size**
int size()
Returns the number of elements in the list.

**add**
int add(E element)
Adds the specified element to the end of the list and returns the index where the element was added.

int add(E item, int index)
Inserts the specified element at the specified position in the list and returns the index where the element was added.

**remove**
E remove(int index)
Removes the element at the specified position in the list and returns the removed element.

boolean remove(E item)
Removes the first occurrence of the specified element from the list and returns true if the element was removed, otherwise false.

**contains**
boolean contains(Object data)
Returns true if the list contains the specified element, otherwise false.

**clear**
void clear()
Removes all of the elements from the list.

**indexOf**
int indexOf(Object o)
Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.

**lastIndexOf**
int lastIndexOf(Object o)
Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.

**sort**
void sort()
Sorts the elements of the list in ascending order.

**toString**
String toString()
Returns a string representation of the list.

# Example
public class Main {
    public static void main(String[] args) {
        // MyArrayList tests
        MyArrayList<Integer> arrList = new MyArrayList<>();
        arrList.add(5);
        arrList.add(8);
        arrList.add(3);
        arrList.add(2, 1);
        System.out.println(arrList); // [5, 2, 8, 3]
        System.out.println(arrList.get(2)); // 8
        System.out.println(arrList.remove(1)); // 2
        System.out.println(arrList); // [5, 8, 3]
        System.out.println(arrList.contains(8)); // true
        arrList.sort();
        System.out.println(arrList); // [3, 5, 8]
        arrList.clear();
        System.out.println(arrList); // []

        // MyLinkedList tests
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");
        linkedList.add("grape", 2);
        System.out.println(linkedList); // [apple, banana, grape, orange]
        System.out.println(linkedList.get(2)); // grape
        System.out.println(linkedList.remove("banana")); // true
        System.out.println(linkedList); // [apple, grape, orange]
        System.out.println(linkedList.contains("orange")); // true
        linkedList.sort();
        System.out.println(linkedList); // [apple, grape, orange]
        linkedList.clear();
        System.out.println(linkedList); // []
    }
}
