class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScores = new int[n + 1];

                for (int[] relation : trust) {
                            int thruster = relation[0];
                                        int trustee = relation[1];
                                                    
                                                                // The person who trusts someone else cannot be the judge
                                                                            trustScores[thruster]--;
                                                                                        
                                                                                                    // The person being trusted gains a point
                                                                                                                trustScores[trustee]++;
                                                                                                                        }

                                                                                                                                // The judge must have a net score of n - 1 
                                                                                                                                        // (trusted by n-1 people and trusts 0 people)
                                                                                                                                                for (int i = 1; i <= n; i++) {
                                                                                                                                                            if (trustScores[i] == n - 1) {
                                                                                                                                                                            return i;
                                                                                                                                                                                        }
                                                                                                                                                                                                }

                                                                                                                                                                                                        return -1;
    }
}