package Practice;

public class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;        
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    public int TwoSum(int[] arr){
      int i = 0;
  
      for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

      return i +1;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 7};

        Solution sort = new Solution();
        int i = sort.TwoSum(arr);

        for (int j = 0; j < i + 1; j++) {
            System.out.println("--" + arr[j]);
        }
    }
    
}