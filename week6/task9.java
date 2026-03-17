class Solution {
    public int expand(String s, int l, int r){
    
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0) return "";
        int start=0;
        int end=0;
        for(int i=0; i<n; i++){
            int even = expand(s, i, i+1); 
            int odd = expand(s, i, i);
            
            int maxLen = Math.max(even, odd); 

            if(maxLen>end-start){
                start = i-(maxLen-1)/2;
                end = i+maxLen/2; 
            }
        }

        return s.substring(start, end+1);
    }
}
