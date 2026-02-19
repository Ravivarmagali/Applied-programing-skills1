class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int curMax = 0;
        int maxSum = nums[0];

        int curMin = 0;
        int minSum = nums[0];

        for (int n : nums) {

            // Kadane for maximum subarray
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(maxSum, curMax);

            // Kadane for minimum subarray
            curMin = Math.min(curMin + n, n);
            minSum = Math.min(minSum, curMin);

            total += n;
        }

        // Edge case: all numbers negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Return maximum of normal and circular
        return Math.max(maxSum, total - minSum);
    }
}