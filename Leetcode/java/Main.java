import java.util.Collections;
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

  // BAD SOLUTION
  public static Integer maxProfit(int[] prices) {

    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      for (int j = (i + 1); j < prices.length; j++) {

        int result = prices[j] - prices[i];

        if (result > maxProfit) {
          maxProfit = result;
        }

      }
    }

    return maxProfit;
  }

  public static Integer maxProfitBestSolution(int[] prices) {

    int lucroMaximo = 0;

    int valorCompra = prices[0];

    for (int valorVenda : prices) {

      if (valorVenda > valorCompra) {
        // lucro
        lucroMaximo = Integer.max(lucroMaximo, (valorVenda - valorCompra));
      } else {
        valorCompra = valorVenda;
      }
    }
    return lucroMaximo;
  }

  public static Integer maxProfitTwo(int[] prices) {

    int lucroMaximo = 0;

    int valorCompra = prices[0];

    for (int valorVenda : prices) {

      if (valorVenda > valorCompra) {
        // lucro
        lucroMaximo += valorVenda - valorCompra;
        valorCompra = valorVenda;
      } else {
        valorCompra = valorVenda;
      }
    }
    return lucroMaximo;
  }

  public static int romanToInteger(String s) {

    Map<Character, Integer> romanMap = new HashMap<>();

    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    Integer sum = 0;

    char[] arr = s.toCharArray();

    Integer previousValue = 0;

    for (int i = arr.length - 1; i >= 0; i--) {

      Integer currentValue = romanMap.get(arr[i]);

      if (currentValue >= previousValue) {
        sum += currentValue;
      } else {
        sum -= currentValue;
      }

      previousValue = currentValue;
    }

    return sum;

  }

  public static boolean isSubsequence(String s, String t) {

    if ((s.length() > t.length())) {
      return false;
    }

    if (s.isEmpty()) {
      return true;
    }

    int firstLetter = 0;
    int lastLetter = s.length() - 1;

    int totalLength = s.length();

    for (int i = 0; i < t.toCharArray().length; i++) {

      if (s.toCharArray()[firstLetter] == (t.toCharArray()[i])) {
        totalLength--;
        firstLetter++;
      }

      if (s.toCharArray()[lastLetter] == (t.toCharArray()[(t.length() - 1) - i])) {
        totalLength--;
        lastLetter--;
      }

      if (totalLength <= 0) {
        return true;
      }
    }

    return false;

  }

  public static boolean isSubsequenceV2(String s, String t) {

    if (s.isEmpty())
      return true;
    int pointer = 0;
    char[] newS = s.toCharArray();

    for (char letter : t.toCharArray()) {

      if (letter == newS[pointer]) {
        pointer++;
      }

      if (pointer == s.length()) {
        return true;
      }

    }

    return false;

  }

  public static int firstUniqueCharecter(String s) {

    Map<Character, Integer> map = new HashMap<>();

    char[] sChar = s.toCharArray();

    for (int i = 0; i < sChar.length; i++) {

    }

    return -1;

  }

  public static int lengthOfLastWord(String s) {

    String[] x = s.split(" ");

    return x[x.length - 1].length();
  }

  public int lengthOfLastWord2(String s) {
    int count = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        count++;
      } else if (count > 0) {
        return count;
      }
    }
    return count;
  }

  // Wrong solution
  public static int strStr(String haystack, String needle) {

    // Haystack is the bigger word
    // Pointer on the needle
    int needlePoint = 0;

    for (int i = 0; i < haystack.length(); i++) {

      if (haystack.charAt(i) == needle.charAt(needlePoint)) {
        needlePoint++;
      } else {
        needlePoint = 0;
      }
      if (needlePoint == needle.length()) {
        return i - (needlePoint - 1);
      }

    }
    return -1;
  }

  public static void x() {

    HashMap<String, String> hash = new HashMap<>();

    System.out.println(hash.getOrDefault("ofien", "oifenf"));

  }

  // Given a 1-indexed array of integers numbers that is already sorted in
  // ascending 0->8 order, find two numbers such that they add up to a specific
  // target number. Let these two numbers be numbers[index1] and numbers[index2]
  // where 1 <= index1 < index2 <= numbers.length.
  //
  // Return the indices of the two numbers, index1 and index2, added by one as an
  // integer array [index1, index2] of length 2.
  //
  // The tests are generated such that there is exactly one solution. You may not
  // use the same element twice.
  //
  // Your solution must use only constant extra space.
  //
  //
  // Example 1:
  //
  // Input: numbers = [2,7,11,15], target = 9
  // Output: [1,2]
  // Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
  // return [1, 2].
  //
  // Example 2:
  //
  // Input: numbers = [2,3,4], target = 6
  // Output: [1,3]
  // Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
  // return [1, 3].
  //
  // Example 3:
  //
  // Input: numbers = [-1,0], target = -1
  // Output: [1,2]
  // Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
  // return [1, 2].
  //
  //
  //
  // Constraints:
  //
  // 2 <= numbers.length <= 3 * 104
  // -1000 <= numbers[i] <= 1000
  // numbers is sorted in non-decreasing order.
  // -1000 <= target <= 1000
  // The tests are generated such that there is exactly one solution.
  //
  // First but not great solution
  public static int[] forgetTheName(int[] numbers, int target) {

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
          return new int[] { i + 1, j + 1 };
        }
      }
    }
    return new int[] { 1 };
  }

  public static void main(String[] args) {

    // int[] prices = {7, 6, 4, 3, 1};
    // System.out.println(romanToInteger("MCMXCIV"));

    // System.out.println(isSubsequenceV2("abc", "ahbgdc"));
    // System.out.println(strStr("mississippi", "issip"));
    System.out.println(forgetTheName(new int[] { 2, 7, 11, 15 }, 9)[0]);
  }
}
