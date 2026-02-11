class Solution {
    public static int nthTerm(int a, int d, int n) {
        return a + (n - 1) * d;
    }

    public static void main(String[] args) {
        int a = 2;   // first term
        int d = 3;   // common difference
        int n = 5;   // nth term
        
        System.out.println(nthTerm(a, d, n));  // Output: 14
    }
}
