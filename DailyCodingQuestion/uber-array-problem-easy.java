/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
*/

import java.util.*;

public class Main {

  // O(nlogn) time | O(1) space - where n is the number of coins
  public static int[] main(int[] given) {
    int size = given.length;
    int[] answer = new int[size];
    System.out.println(size);
    return answer;
  }
}