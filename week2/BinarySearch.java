import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {};

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = arr.length - 1;
        int mid;
        boolean found = false;

       
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Element found at index: " + mid);
                found = true;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Element not found in the array");
        }

        sc.close();
    }
}