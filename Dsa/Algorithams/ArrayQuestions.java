package Algorithams;

public class ArrayQuestions {

    int findtheMissing(int[] arr){
        int[] newarr = new int[arr.length + 2];

        for (int i = 0; i < arr.length; i++) {
            newarr[arr[i]] = 1;
        }

        for (int i = 0; i < newarr.length; i++) {
            if (newarr[i] == 0) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ArrayQuestions questions = new ArrayQuestions();

        int[] arr = {1,2,4,5};
        System.out.println(
            questions.findtheMissing(arr)
        );
    }
}
