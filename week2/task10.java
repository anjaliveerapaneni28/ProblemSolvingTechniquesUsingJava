import java.util.Scanner;

class CyclicDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        String num = sc.nextLine();

        int sum = 0;

        // Calculate sum of digits
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }

        int result = sum * num.length();

        System.out.println("Sum of Sums in cyclic order: " + result);

        sc.close();
    }
}
