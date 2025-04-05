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

    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                cnt++;
                max = Math.max(max, cnt);
            }else{
                cnt = 0;
            }
        }

        return max;
    }

    public void minandmax(int[] arr){
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }else if (arr[i] < min) {
                min = arr[i];
            }
        }


        System.out.println( "Min -- > " + min + "  max -- > " + max );
    }
    
    public static void main(String[] args) {
        ArrayQuestions questions = new ArrayQuestions();

        int[] arr = {56789};
        // System.out.println(
        questions.minandmax(arr);
        // );
    }
}
