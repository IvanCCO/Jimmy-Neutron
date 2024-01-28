import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
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

    public static boolean isAPalindrome(String word) {

        char[] strArr = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int lastPosition = strArr.length - 1;

        for (int i = 0; i < strArr.length; i++) {

            if (strArr[i] != strArr[lastPosition - i]) {
                return false;
            }

        }
        return true;
    }


    public static void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {

            // trocar ultimo com primeiro
            int aux = nums[0];
            nums[0] = nums[nums.length - 1];

            for (int j = 1; j < nums.length; j++) {

                int aux2 = nums[j];

                nums[j] = aux;

                aux = aux2;
            }
        }
    }

    public static boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        char[] arr = pattern.toCharArray();
        int currentPositionPattern = 0;

        Map<Character, String> map = new Hashtable<Character, String>();


        for (Character letter : arr) {

            if (!map.containsKey(letter)) {
                map.put(letter, words[currentPositionPattern]);
                currentPositionPattern++;
            } else {
                if (map.get(letter).equals(words[currentPositionPattern])) {
                    currentPositionPattern++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(wordPattern("abaa", "cat dog cat cat"));

    }
}
