import java.util.Scanner;

class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int count = 0;

        num = Math.abs(num);  // Handle negative numbers

        if (num == 0) {
            count = 1;
        } else {
            while (num > 0) {
                num = num / 10;
                count++;
            }
        }

        System.out.println("Total digits: " + count);
        sc.close();
    }
}
