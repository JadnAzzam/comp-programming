// Multi String Search 
// Write a function that takes in a big string and an array of small strings, 
// all of which are smaller in length than the big string. 
// The function should return an array of booleans, 
// where each boolean represents whether the small string at that index in the array of small 
//   strings is contained in the big string.

// Note that you can't use language-built-in string-matching methods.

// Sample Input #1
// bigString = "this is a big string"
// smallStrings = ["this", "yo", "is", "a", "bigger", "string", "kappal"]

// Sample Output #1
// [true, false, true, true, false, true, false]

// Sample Input #2
// bigString = "abcdefghijklmnopqrstuvwxyz"
// smallStrings = ["abc", "mnopqr", "wyz", "no", "e", "tuuv"]

// Sample Output #2
// [true, true, false, true, true, false]


// /////////////////////////////////  Solution 1: O(bns) time | O(n) space  ///////////////////////////////////////////////////////////
class Program {
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) { 
    List<Boolean> solution = new ArrayList<Boolean>();
    for (String smallString: smallStrings) {
      solution.add(isInBigString(bigString, smallString));
    }
    return solution;
  }
  
  
    public static boolean isInBigString(String bigString, String smallString) {
      for (int i = 0; i < bigString.length(); i++) {
        if (i + smallString.length() > bigString.length()) {
          break;
        }
        if (isInBigString(bigString, smallString, i)) {
          return true;
        }
      }
      return false;
    }
  
    public static boolean isInBigString(String bigString, String smallString, int startIdx) { 
      int leftBigIdx = startIdx;
      int rightBigIdx = startIdx + smallString.length() - 1;
      int leftSmallIdx = 0;
      int rightSmallIdx = smallString.length() - 1;
  
      while (leftBigIdx <= rightBigIdx) {
        if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx) 
            || bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
           return false;
        }
        leftBigIdx++;
        rightBigIdx--;
        leftSmallIdx++;
        rightSmallIdx--;
      }
      return true;
    }
  }
  
  
  // /////////////////////////////////////////////////// Solution 2: O(b^2 + ns) time | O(b^2 + n) space  /////////////////////////////////////////////////
  import java.util.*;
  
  class Program {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
      ModifiedSuffixTrie modifiedSuffixTrie = new ModifiedSuffixTrie(bigString);
      List<Boolean> solution = new ArrayList<Boolean>();
      for (String smallString : smallStrings) {
        solution.add(modifiedSuffixTrie.contains(smallString));
      }
      return solution;
    }
  
    static class TrieNode {
      Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }
  
    static class ModifiedSuffixTrie {
      TrieNode root = new TrieNode();
  
      public ModifiedSuffixTrie(String str) {
        populateModifiedSuffixTrieFrom(str);
      }
  
      public void populateModifiedSuffixTrieFrom(String str) {
        for (int i = 0; i < str.length(); i++) {
          insertSubstringStartingAt(i, str);
        }
      }
  
      public void insertSubstringStartingAt(int i, String str) {
        TrieNode node = root;
        for (int j = i; j < str.length(); j++) {
          char letter = str.charAt(j);
          if (!node.children.containsKey(letter)) {
            TrieNode newNode = new TrieNode();
            node.children.put(letter, newNode);
          }
          node = node.children.get(letter);
        }
      }
  
      public boolean contains(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
          char letter = str.charAt(i);
          if (!node.children.containsKey(letter)) {
            return false;
          }
          node = node.children.get(letter);
        }
        return true;
      }
    }
  }
  
  // /////////////////////////////////////////////////// Solution 3:  O(ns + bs) time | O(ns) space /////////////////////////////////////////////////
  
  import java.util.*;
  
  class Program {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
      Trie trie = new Trie();
      for (String smallString : smallStrings) {
        trie.insert(smallString);
      }
      Set<String> containedStrings = new HashSet<String>();
      for (int i = 0; i < bigString.length(); i++) {
        findSmallStringsIn(bigString, i, trie, containedStrings);
      }
      List<Boolean> solution = new ArrayList<Boolean>();
      for (String str : smallStrings) {
        solution.add(containedStrings.contains(str));
      }
      return solution;
    }
  
    public static void findSmallStringsIn(
        String str, int startIdx, Trie trie, Set<String> containedStrings) {
      TrieNode currentNode = trie.root;
      for (int i = startIdx; i < str.length(); i++) {
        char currentChar = str.charAt(i);
        if (!currentNode.children.containsKey(currentChar)) {
          break;
        }
        currentNode = currentNode.children.get(currentChar);
        if (currentNode.children.containsKey(trie.endSymbol)) {
          containedStrings.add(currentNode.word);
        }
      }
    }
  
    static class TrieNode {
      Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
      String word;
    }
  
    static class Trie {
      TrieNode root = new TrieNode();
      char endSymbol = '*';
  
      public void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
          char letter = str.charAt(i);
          if (!node.children.containsKey(letter)) {
            TrieNode newNode = new TrieNode();
            node.children.put(letter, newNode);
          }
          node = node.children.get(letter);
        }
        node.children.put(endSymbol, null);
        node.word = str;
      }
    }
  }