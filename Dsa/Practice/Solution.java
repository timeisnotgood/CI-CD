package Practice;

import java.util.Arrays;

public class Solution {

    int size;
    int capacity = 10;
    int[] data;

    Solution(){
        this.data = new int[capacity];
    }
    Solution(int cap){
        this.capacity = cap;
        this.data = new int[capacity];
    }

    int getValueByIndex(int index){
        if (size == 0) {
            System.out.println("Array is Empty");
        }
        return data[index];
    }

    void extendCapacity(){
        data = Arrays.copyOf(data, capacity * 2);
        capacity *= 2;
    }

    int push(int val){
        if (size == capacity) {
            extendCapacity();
        }
        data[size] = val;
        size ++;
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    public static void main(String[] args) {
        Solution Array = new Solution();

        Array.push(16);
        Array.push(2);
        Array.push(3);
        Array.push(4);
        Array.push(5);

        System.out.println(Array);
    }

}