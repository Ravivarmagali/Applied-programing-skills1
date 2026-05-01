class Solution {
    public int rob(int[] nums) {
     if (nums == null || nums.length == 0) return 0;
             if (nums.length == 1) return nums[0];

                     int prev2 = 0; // Max money 2 houses ago
                             int prev1 = 0; // Max money 1 house ago

                                     for (int num : nums) {
                                                 // Option 1: Rob this house (num + prev2)
                                                             // Option 2: Skip this house (prev1)
                                                                         int current = Math.max(prev1, num + prev2);
                                                                                     prev2 = prev1;
                                                                                                 prev1 = current;
                                                                                                         }

                                                                                                                 return prev1;   
    }
}