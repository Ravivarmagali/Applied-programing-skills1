class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
       int[][] dp = new int[m + 1][n + 1];

               for (String s : strs) {
                           // Count zeroes and ones in the current string
                                       int zeroes = 0, ones = 0;
                                                   for (char c : s.toCharArray()) {
                                                                   if (c == '0') zeroes++;
                                                                                   else ones++;
                                                                                               }

                                                                                                           // Update DP table from right to left (bottom-up)
                                                                                                                       // We go backwards to avoid using the same string multiple times
                                                                                                                                   for (int i = m; i >= zeroes; i--) {
                                                                                                                                                   for (int j = n; j >= ones; j--) {
                                                                                                                                                                       dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                                                                                                                                                                                       }
                                                                                                                                                                                                   }
                                                                                                                                                                                                           }

                                                                                                                                                                                                                   return dp[m][n]; 
    }
}