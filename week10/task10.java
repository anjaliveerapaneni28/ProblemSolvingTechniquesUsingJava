class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char c=letters[0];
        
        for(char x:letters)
        {
            if(x>target)
            {
                return x;

            }
        }
        return c;
    }
}
