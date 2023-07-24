// Find Three Largest Numbers
// Write a function that takes in an array of at least three integers and, without sorting the input array, returns a sorted array of the three largest integers in the input array.

// The function should return duplicate integers if necessary; for example, it should return [10, 10, 12] for an input array of [10, 5, 9, 10, 12].

// Sample Input
// array = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]
// Sample Output
// [18, 141, 541]

import java.util.*;

class Program {
  public static int[] findThreeLargestNumbers(int[] array) {
    int first = array[0];
    int second = array[1];
    int third = array[2];

    if (third > first) {
      int temp = first;
      first = third;
      third = temp;
    }
    if (second > first) {
      int temp1 = second;
      second = first;
      first = temp1;
    }
    if (third > second) {
      int temp2 = second;
      second = third;
      third = temp2;
    }

    for (int i = 3; i < array.length; i++) {
      if (array[i] > first) {
        third = second;
        second = first;
        first = array[i];
      } else if (array[i] > second) {
        third = second;
        second = array[i];
      } else if (array[i] > third) {
        third = array[i];
      }
    }
