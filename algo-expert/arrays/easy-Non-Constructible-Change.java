/* 
Non-Constructible Change
Given an array of positive integers representing the values of coins in your possession, 
write a function that returns the minimum amount of change (the minimum sum of money) that you cannot create. 
The given coins can have any positive integer value and aren't necessarily unique 
(i.e., you can have multiple coins of the same value).

For example, if you're given coins = [1, 2, 5], the minimum amount of change that you can't create is 4. 
If you're given no coins, the minimum amount of change that you can't create is 1.

Sample Input
coins = [5, 7, 1, 1, 2, 3, 22]
Sample Output
20

*/

import java.util.*;

class Program {
  // O(nlogn) time and | O(1) space
  
  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
    int currentChange = 0;   //to sum up the number of change we can currently create 
    Arrays.sort(coins);      // sort the array in O(nlognn)
    
    for(int i=0;i<coins.length ; i++){  // if the next index is greater than what we can creats
      if(currentChange+1 < coins[i]){   // by more than 1, then cuurentChange+1 can be made 
        return currentChange+1;
      }
      currentChange = currentChange + coins[i];
    }
    return currentChange+1;
  }
}
