public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        System.out.println(myList.get(1)); // Output: 2

        System.out.println(myList.size()); // Output: 3

        myList.remove(1);
        System.out.println(myList.get(1)); // Output: 3
        System.out.println(myList.size()); // Output: 2

        System.out.println(myList.contains(1)); // Output: false
        System.out.println(myList.contains(3)); // Output: true

        myList.add(5);
        myList.add(4);
        myList.sort();
        System.out.println(myList.get(0)); // Output: 4
        System.out.println(myList.get(1)); // Output: 5
        System.out.println(myList.get(2)); // Output: 3

        MyList<String> linkedList = new MyLinkedList<>();

        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("!");

        System.out.println(linkedList.get(1)); // Output: world

        System.out.println(linkedList.size()); // Output: 3

        linkedList.remove(1);
        System.out.println(linkedList.get(1)); // Output: !

        System.out.println(linkedList.contains("world")); // Output: false
        System.out.println(linkedList.contains("!")); // Output: true
    }
}