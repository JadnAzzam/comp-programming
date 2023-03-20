// Given two non-empty arrays of integers, 
// write a function that determines whether the second array is a subsequence of the first one.
// A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array. 
//   For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4].
//   Note that a single number in an array and the array itself are both valid subsequences of the array.

//   Sample Input
// array = [5, 1, 22, 25, 6, -1, 8, 10] sequence = [1, 6, -1, 10]

// Sample Output
// true

// Solution 1:  O(n) time 0(1) space 
import java.util.*;
class Program {
  public static boolean isvalidsubsequence(List<Integer> array, List<Integer> sequence) {
    int seqIdx = 0; 
    for (var value : array) { 
      if (seqIdx == sequence.size()) {
        break;
      if (sequence.get(seqidx).equals(value)) {
        seqIdx++;
        }
      } 
      return seqIdx == sequence.size();
    }
  }


// Solution 1:  O(n) time | 0(1) space 
import java.util.*;
class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int arrIdx = 0; 
    int seqIdx = 0; 
    while (arrIdx < array.size() && seqIdx < sequence.size()) { 
      if (array.get(arrIdx).equals(sequence.get(seqidx))) {
        seqIdxt;
      }
      arrIdx;
    }
    return seqIdx == sequence.size();
  }
}