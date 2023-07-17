// Three Number Sum
// Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be ordered in ascending order with respect to the numbers they hold.

// If no three numbers sum up to the target sum, the function should return an empty array.

// Sample Input
// array = [12, 3, 1, 2, -6, 5, -8, 6]
// targetSum = 0

// Sample Output
// [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]

import java.util.*;

class Program {
  public static ArrayList<ArrayList<Integer>> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(array);
    for(int idx=0; idx<array.length; idx++){
      int left = idx+1;
      int right = array.length -1;
      
      while(left<right){
        int sum = array[idx]+array[left]+array[right];
        if(sum == targetSum){
          ArrayList<Integer> ans = new ArrayList<Integer>();
          ans.add(array[idx]);
          ans.add(array[left]);
          ans.add(array[right]);
          result.add(ans);
          // count ++;
        }
        if(sum < targetSum){
          left++;
        }
        else{
          right--;
        }
      }
    }
    return result;
  }
}