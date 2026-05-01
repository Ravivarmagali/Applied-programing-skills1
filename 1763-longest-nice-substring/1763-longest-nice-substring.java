class Solution {
    public String longestNiceSubstring(String s) {
      if (s.length() < 2) return "";

                      // Store all characters present in the current string
                              Set<Character> set = new HashSet<>();
                                      for (char c : s.toCharArray()) {
                                                  set.add(c);
                                                          }

                                                                          // Find a character that doesn't have its pair (upper/lower)
                                                                                  for (int i = 0; i < s.length(); i++) {
                                                                                              char c = s.charAt(i);
                                                                                                          if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                                                                                                                          continue;
                                                                                                                                      }

                                                                                                                                                              // If we reach here, s.charAt(i) is a "bad" character.
                                                                                                                                                                          // Split the string and check both sides.
                                                                                                                                                                                      String left = longestNiceSubstring(s.substring(0, i));
                                                                                                                                                                                                  String right = longestNiceSubstring(s.substring(i + 1));

                                                                                                                                                                                                                          // Return the longer one; if tied, return the left (earliest occurrence)
                                                                                                                                                                                                                                      return left.length() >= right.length() ? left : right;
                                                                                                                                                                                                                                              }

                                                                                                                                                                                                                                                              // If the loop finishes, the entire string is nice.
                                                                                                                                                                                                                                                                      return s;  
    }
}