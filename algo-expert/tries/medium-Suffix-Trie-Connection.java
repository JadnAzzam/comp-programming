// Write a SuffixTrie class for a Suffix-Trie-like data structure. 
// The class should have a root property set to be the root node of the trie and should support:
//   • Creating the trie from a string; this will be done by calling the populateSuffixTrieFrom method upon class instantiation, which should populate the root of the class.
//   • Searching for strings in the trie.

// Note that every string added to the trie should end with the special endSymbol character: "*".
// If you're unfamiliar with Suffix Tries, we recommend watching the Conceptual Overview section ofthis question's video explanation before starting to code.

// Sample Input (for creation)
// string = "babc"

// Sample Output (for creation)
// The structure below is the root of the trie.
// {
//   "c": {"*": true},
//   "b": {
//       "c": {"*": true},
//       "a": {"b": {"c": {"*": true}}},
//     },
//     "a": {"b": {"c": {"*": true}}},
// }

// Sample Input (for searching the suffix trie above):
//   string = "abc"

// Sample Output (for searching the suffix trie above):
//  true 

// Solution:

import java.util.*;
class Program { 
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class Suffixtrie {
    TrieNode root = new TrieNode(); 
    char endsymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    // O(n^2) time | O(n^2) space 
    public void populateSuffixTrieFrom(String str) { 
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
      node.children.put(endsymbol, null);
    }

      // o(m) time | 0(1) space 
      public boolean contains(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
          char letter = str.charAt(i);
          if (!node.children.containsKey(letter)) {
            return false;
          }
          node = node.children.get(letter);
        }
        return node.children.containsKey(endsymbol);