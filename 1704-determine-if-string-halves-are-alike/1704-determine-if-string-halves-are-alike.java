class Solution {
    public static boolean halvesAreAlike(String s) {
        int j = 0;
        int n = s.length()/2;
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            char ce = s.charAt(n+i);
            if(c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U')
            j++;
            if(ce == 'a' || ce == 'e'|| ce == 'i'|| ce == 'o'|| ce == 'u'|| ce == 'A'|| ce == 'E'|| ce == 'I'|| ce == 'O'|| ce == 'U')
            j--;
        }
        return j==0;
    }
}
