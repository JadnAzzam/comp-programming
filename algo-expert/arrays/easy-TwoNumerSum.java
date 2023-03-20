// Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. 
// If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. 
// If no two numbers sum up to the target sum, the function should return an empty array.
// Note that the target sum has to be obtained by summing two different integers in the array; you can't add a single integer to itself in order to obtain the target sum.
// You can assume that there will be at most one pair of numbers summing up to the target sum.

// Sample Input:
// array = [3, 5, -4, 8, 11, 1, -1, 6] targetSum = 10

// Sample Output:
// [-1, 11]   // the numbers could be in reverse order


// SOLUTION 1 O(n^2) time | 0(1) space
class Program {  
public static int[] twoNumberSum(int[] array, int targetsum) { 
  for (int i = 0; i < array.length - 1; i++) {
    int firstNum = array[i]; 
    for (int j = i + 1; j < array.length; j++) {
      int secondNum = array[j]; 
      if (firstNum + secondNum == targetSum) {
        return new int[] {firstNum, secondNum};
      }
    }
  }
  return new int[0];
}


// SOLUTION 2: // O(n) time | O(n) space 
import java.util.*;
class Program {     
public static int[] twoNumberSum(int[] array, int targetsum) {
  Set<Integer> nums = new HashSet<>(); 
  for (int num : array) {
    int potentialMatch = targetSum - num; 
    if (nums.contains(potentialMatch)) {
      return new int[] {potentialMatch, num}; 
    } else {
      nums.add(num);
    }
  }
  return new int[0]; 
 } 
}


// SOLUTION 3:  // O(nlog(n)) | 0(1) space 
import java.util.Arrays;
class Program { 
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Arrays.sort(array); 
    int left = 0; 
    int right = array.length - 1; 
    while (left < right) {
      int currentSum = array[left] + array[right]; 
      if (currentSum == targetSum) {
        return new int[] {array[left], array[right]}; 
      } else if (currentSum < targetsum) {
        left++; 
      } else if (currentSum > targetSum) {
        right--;
      }
    }
    return new int[0];
  }
}