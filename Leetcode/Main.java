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

  public static void main(String[] args) {

    int[] num = { 2, 2, 1, 1, 1, 1, 2, 1 };

    System.out.println(majorityElement(num));

  }
}
