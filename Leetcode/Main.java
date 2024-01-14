import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static int majorityElement(int[] nums) {

    Map<Integer, Integer> hash = new HashMap<>();

      for (int num : nums) {

          hash.put(num, (hash.getOrDefault(num, 0) + 1));

          if (hash.get(num) > nums.length / 2) {
              return num;
          }

      }

    return 0;

  }


  public static void rotate(int[] nums, int k){

      for(int i = 0; i<k; i++){

          // trocar ultimo com primeiro
          int aux = nums[0];
          nums[0] = nums[nums.length-1];

          for(int j = 1; j< nums.length; j++){

             int aux2 = nums[j];

             nums[j] = aux;

             aux = aux2;
          }
      }
  }

  public static void main(String[] args) {

    int[] num = { 1,2,3,4,5,6,7 };


    rotate(num, 3);

  }
}
