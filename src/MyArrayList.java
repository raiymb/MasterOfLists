public class MyArrayList {
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



}
