class Solution {
    public static int alternateSum(int n) {
        if (n % 2 == 0)
            return -(n / 2);
        else
            return (n + 1) / 2;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(alternateSum(n));  // Output: -3
    }
}
