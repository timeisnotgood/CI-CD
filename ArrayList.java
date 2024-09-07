import java.util.*;

public class ArrayList {
    public static void main(String[] args) {
        System.out.println("1");

        DataStructure();
    }

    static void DataStructure(){
        List<String> array = new LinkedList<>();
        array.add("one");
        array.add("two");
        array.add("three");
        array.add("four");
        array.add("five");

        System.out.println("ArrayList-->"+ array.get(2));

        List<String> linked = new LinkedList<>();
        linked.add("one");
        linked.add("two");
        linked.add("three");
        linked.add("four");
        linked.add("five");
        linked.add("six");


        
        System.out.println("linkedList"+ linked.get(1));

    }
}
