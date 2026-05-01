class Solution {
    public int uniquePaths(int m, int n) {
    // Use a 1D array to save space
            int[] dp = new int[n];

                            // Base case: There is only 1 way to reach any cell in the first row
                                    for (int i = 0; i < n; i++) {
                                                dp[i] = 1;
                                                        }

                                                                        // Fill the DP table row by row
                                                                                for (int i = 1; i < m; i++) {
                                                                                            for (int j = 1; j < n; j++) {
                                                                                                            // The new dp[j] = dp[j] (value from top) + dp[j-1] (value from left)
                                                                                                                            dp[j] += dp[j - 1];
                                                                                                                                        }
                                                                                                                                                }

                                                                                                                                                                return dp[n - 1];    
    }
}