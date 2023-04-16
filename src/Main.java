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