class Solution {
    public int minCostClimbingStairs(int[] cost) {
     int n = cost.length;
             int prev2 = 0; // Cost to reach 2 steps ago
                     int prev1 = 0; // Cost to reach 1 step ago

                                     // Iterate through each step starting from the first two available
                                             for (int i = 2; i <= n; i++) {
                                                         // To reach step i, you could come from i-1 or i-2
                                                                     int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
                                                                                 prev2 = prev1;
                                                                                             prev1 = current;
                                                                                                     }

                                                                                                                     return prev1;   
    }
}