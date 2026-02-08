class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int a=i;
            int b=i+1;
            char r=s.charAt(a);
            char rr=s.charAt(b);
            int aa=r;
            int aaa=rr;
            int rrr=Math.abs(aa-aaa);
            ans=ans+rrr;
        }
        return ans;
    }
}