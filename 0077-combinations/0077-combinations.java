class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
                backtrack(result, new ArrayList<>(), 1, n, k);
                        return result;
                            }

                                private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
                                        // Base case: If the combination is the required size k
                                                if (tempList.size() == k) {
                                                            result.add(new ArrayList<>(tempList));
                                                                        return;
                                                                                }

                                                                                        // Optimization: i <= n - (k - tempList.size()) + 1
                                                                                                // This ensures there are enough numbers left to reach size k
                                                                                                        for (int i = start; i <= n; i++) {
                                                                                                                    tempList.add(i);
                                                                                                                                backtrack(result, tempList, i + 1, n, k);
                                                                                                                                            tempList.remove(tempList.size() - 1);
                                                                                                                                                    }
        
    }
}