class Solution {
    public String reverse(String s){
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev = rev + s.charAt(i);
        }
        return rev;
    }
    public int maximumNumberOfStringPairs(String[] words) {
        int ans=0;
        int n=words.length;
        for (int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                String r= words[i];
                String a= words[j];
                String ravi= reverse(a);
                if(ravi.equals(r)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}