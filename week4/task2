import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); 

        while (T-- > 0) {

            String s = sc.nextLine();
            int n = s.length();
            int mid = n / 2;

            int[] left = new int[26];
            int[] right = new int[26];

            for (int i = 0; i < mid; i++) {
                char ch = s.charAt(i);
                left[ch - 'a']++;
            }

            
            int start;
            if (n % 2 == 0) {
                start = mid;
            } else {
                start = mid + 1;
            }

            for (int i = start; i < n; i++) {
                char ch = s.charAt(i);
                right[ch - 'a']++;
            }

            if (Arrays.equals(left, right)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}


