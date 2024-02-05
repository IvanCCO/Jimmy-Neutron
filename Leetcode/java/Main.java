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

        if (s.isEmpty()) return true;
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

        for(int i = 0; i<haystack.length(); i++) {

           if(haystack.charAt(i) == needle.charAt(needlePoint)){
               needlePoint++;
           }else{
               needlePoint=0;
           }
           if(needlePoint == needle.length()){
               return i - (needlePoint-1);
           }

        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] prices = {7, 6, 4, 3, 1};
//        System.out.println(romanToInteger("MCMXCIV"));

//        System.out.println(isSubsequenceV2("abc", "ahbgdc"));
        System.out.println(strStr("mississippi", "issip"));

    }
}
