class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        char[] map1 = new char[26];
        char[] map2 = new char[26];

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // if not mapped yet
            if (map1[p - 'a'] == 0 && map2[w - 'a'] == 0) {

                map1[p - 'a'] = w;
                map2[w - 'a'] = p;
            }

            // if mapping mismatch
            else if (map1[p - 'a'] != w || map2[w - 'a'] != p) {

                return false;
            }
        }

        return true;
    }
}