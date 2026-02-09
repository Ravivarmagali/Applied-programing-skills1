class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int countA = 0, countB = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }
            if (vowels.indexOf(s.charAt(i + mid)) != -1) {
                countB++;
            }
        }
        return countA == countB;
    }
}
