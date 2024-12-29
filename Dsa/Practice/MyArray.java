package Practice;

import java.util.Arrays;

class Arry {
    
    int size = 0;
    int capacity = 10;
    int[] data;

    Arry(){
        this.data = new int[capacity];
    }
    Arry(int cap){
        this.capacity = cap;
        this.data = new int[capacity];
    }

    int get(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of Bound");
        }
        return data[index];
    }

    int push(int value){
        data[size] = value;
        this.size++;
        return size;
    }

    // Convert the array to a string for printing
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}

class MyArray {

    public static void main(String[] args) {

        Arry array = new Arry();
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(14);

        System.out.println("Getting ----> "+ array);
    }
}