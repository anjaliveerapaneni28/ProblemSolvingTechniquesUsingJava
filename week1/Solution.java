import java.util.Scanner;

// Functional Interface
interface PerformOperation {
    boolean check(int n);
}

public class Solution {

    // Returns true if number is odd
    static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Returns true if number is prime
    static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    // Returns true if number is palindrome
    static PerformOperation isPalindrome() {
        return n -> {
            int temp = n, rev = 0;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            return rev == n;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int choice = sc.nextInt();
            int num = sc.nextInt();

            if (choice == 1)
                System.out.println(isOdd().check(num) ? "ODD" : "EVEN");
            else if (choice == 2)
                System.out.println(isPrime().check(num) ? "PRIME" : "COMPOSITE");
            else if (choice == 3)
                System.out.println(isPalindrome().check(num) ? "PALINDROME" : "NOT PALINDROME");
        }

        sc.close();
    }
}
