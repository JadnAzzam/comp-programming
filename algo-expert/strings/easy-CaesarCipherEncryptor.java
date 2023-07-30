// Caesar Cipher Encryptor
// Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that returns a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k is the key.

// Note that letters should "wrap" around the alphabet; in other words, the letter z shifted by one returns the letter a.

// Sample Input
// string = "xyz"
// key = 2
// Sample Output
// "zab"

import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
    // Write your code here.
    char[] NewLetters = new char[str.length()];

    for(int i = 0; i<str.length(); i++){
      int NewLetterCode = str.charAt(i) + (key%26);
      
      if(NewLetterCode <= 122 ){
        NewLetters[i] = (char) NewLetterCode;
      }
      else{
        // int NewLetterCode = 96 + (str.charAt(i) + (key%26) - 122);
        NewLetters[i] = (char) (96 + (NewLetterCode%122));
      }
    }
    
    return new String(NewLetters);
  }
}
