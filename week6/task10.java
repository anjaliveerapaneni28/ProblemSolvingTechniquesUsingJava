import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'circularPalindromes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING s as parameter.
     */

public static List<Integer> circularPalindromes(String s) {
    int n = s.length();
    String t = s + s;

    int[] d1 = manacherOdd(t);
    int[] d2 = manacherEven(t);

    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        int maxLen = 1;

        for (int j = i; j < i + n; j++) {
            int len1 = Math.min(d1[j], Math.min(j - i + 1, i + n - j));
            maxLen = Math.max(maxLen, 2 * len1 - 1);

            int len2 = Math.min(d2[j], Math.min(j - i, i + n - j));
            maxLen = Math.max(maxLen, 2 * len2);
        }

        res.add(maxLen);
    }

    return res;
}

// Odd length palindromes
private static int[] manacherOdd(String s) {
    int n = s.length();
    int[] d1 = new int[n];
    int l = 0, r = -1;

    for (int i = 0; i < n; i++) {
        int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
        while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) {
            k++;
        }
        d1[i] = k--;
        if (i + k > r) {
            l = i - k;
            r = i + k;
        }
    }
    return d1;
}

// Even length palindromes
private static int[] manacherEven(String s) {
    int n = s.length();
    int[] d2 = new int[n];
    int l = 0, r = -1;

    for (int i = 0; i < n; i++) {
        int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);
        while (i - k - 1 >= 0 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) {
            k++;
        }
        d2[i] = k--;
        if (i + k > r) {
            l = i - k - 1;
            r = i + k;
        }
    }
    return d2;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
