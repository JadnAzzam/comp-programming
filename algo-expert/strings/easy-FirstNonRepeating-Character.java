// First Non-Repeating Character
// Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's first non-repeating character.

// The first non-repeating character is the first character in a string that occurs only once.

// If the input string doesn't have any non-repeating characters, your function should return -1.

// Sample Input
// string = "abcdcaf"
// Sample Output
// 1 // The first non-repeating character is "b" and is found at index 1.

import java.util.*;

class Program {

  public int firstNonRepeatingCharacter(String string) {
 // Create a HashMap to store the frequency of each character in the string
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Traverse the string to populate the HashMap
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Traverse the string again to find the first non-repeating character
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (freqMap.get(c) == 1) {
                return i;
            }
        }

        // No non-repeating character found
        return -1;
  }
}
