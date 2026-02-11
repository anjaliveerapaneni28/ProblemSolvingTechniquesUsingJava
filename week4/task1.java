class Solution {
    public boolean halvesAreAlike(String s) {
       
        int mid =s.length()/ 2;
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                if (i < mid) {
                    countA++;
                } else {
                    countB++;
                }
            }
        }

        return countA == countB;
    }


    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}

    
