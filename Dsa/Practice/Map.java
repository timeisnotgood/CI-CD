package Practice;


class Nod {
    int key;
    String val;
    Nod next;

    Nod(int key, String val){
        this.key = key;
        this.val = val;
    }
}

class MyHashTable {

    Nod[] table;
    int size;

    MyHashTable(int size){
        table = new Nod[size];
        this.size = size;
    }

    int hash(int key){
        return key % size;
    }

    void put(int key, String val){
        int index = hash(key);
        Nod newNode = new Nod(key, val);


        if (table[index] == null) {
            table[index] = newNode;
            return;
        }

        Nod temp = table[index];

        while (temp.next != null) {
            if (temp.key == key) {
                temp.val = val;
                return;
            }
            temp = temp.next;
        }

        if (temp.key == key) {
            temp.val = val;
            return;
        }

        temp.next = newNode;
    }


    String get(int key){
        int index = hash(key);

        Nod temp = this.table[index];

        while (temp != null) {
            if (temp.key == key) {
                return temp.val;
            }

            temp = temp.next;
        }

        return null;
    }

    void remove(int key){
        int index = hash(key);

        Nod curr = this.table[index];
        Nod prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    this.table[index] = curr.next;
                }else{
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;   
        }
    }

    void display(){
        for (int i = 0; i < table.length; i++) {
            System.out.print("Table [" +i+"] : " );

            Nod temp = this.table[i];

            while (temp != null) {
                System.out.print("( " +temp.key +", " + temp.val +" ) -> ");
                temp = temp.next;
            }
                System.out.println("null");
        }
    }
}


public class Map {

    public static void main(String[] args) {
        MyHashTable obj = new MyHashTable(10);

        obj.put(11, "Nari");
        obj.put(21, "Hari");
        obj.put(2, "siva");

        obj.put(2, "elephent");

        obj.remove(11);

        System.out.println( "Single ---> " + obj.get(2));

        obj.display();
    }
}