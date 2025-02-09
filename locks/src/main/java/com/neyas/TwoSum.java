package com.neyas;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    // Create a HashMap to store the complement and its index
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      // Check if the complement exists in the map
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      // Store the current number and its index in the map
      map.put(nums[i], i);
    }
    // If no solution exists, throw an exception
    throw new IllegalArgumentException("No two sum solution");
  }
}
