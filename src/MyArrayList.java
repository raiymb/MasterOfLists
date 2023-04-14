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

}
