// public class Amazon-array-hard {
  
// }
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String s = "abcba";
        int k = 2;
        System.out.println(longestSubstringKDistinct(s, k));
    }

    public static int longestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while (charFrequency.size() > k) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
