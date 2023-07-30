// Palindrome Check
// Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a palindrome.

// A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.

// Sample Input
// string = "abcdcba"
// Sample Output
// true // it's written the same forward and backward

import java.util.*;

class Program {
  public static boolean isPalindrome(String str) {
    // Write your code here.\
    int length = (int) Math.floor(str.length()/2);
    boolean bool = true;

    for(int i=0; i<length; i++){
      if(str.charAt(i) != str.charAt(str.length()-1-i)){
        bool = false;
      }
    }
    
    return bool;
  }
}
