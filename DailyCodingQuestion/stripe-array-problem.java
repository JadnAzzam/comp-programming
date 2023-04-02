/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

The time complexity of the algorithm is O(n), and the space complexity is O(1).
*/

public class Main {
	public static int findMissingPositive(int[] nums) {
	    int n = nums.length;
	    for (int i = 0; i < n; i++) {
	        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
	            int temp = nums[nums[i] - 1];
	            nums[nums[i] - 1] = nums[i];
	            nums[i] = temp;
	        }
	    }
	    for (int i = 0; i < n; i++) {
	        if (nums[i] != i + 1) {
	            return i + 1;
	        }
	    }
	    return n + 1;
	}

    public static void main(String[] args) {
    	int[] test = {0,3,1};
    	int n = findMissingPositive(test);
        System.out.println(n);
    }
}

