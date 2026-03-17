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
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
     int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Top row
            for (int i = left; i <= right; i++)
                elements.add(matrix.get(top).get(i));

            // Right column
            for (int i = top + 1; i <= bottom - 1; i++)
                elements.add(matrix.get(i).get(right));

            // Bottom row
            for (int i = right; i >= left; i--)
                elements.add(matrix.get(bottom).get(i));

            // Left column
            for (int i = bottom - 1; i >= top + 1; i--)
                elements.add(matrix.get(i).get(left));

            int size = elements.size();
            int rotations = r % size;

            Collections.rotate(elements, -rotations);

            int index = 0;

            // Put back Top row
            for (int i = left; i <= right; i++)
                matrix.get(top).set(i, elements.get(index++));

            // Right column
            for (int i = top + 1; i <= bottom - 1; i++)
                matrix.get(i).set(right, elements.get(index++));

            // Bottom row
            for (int i = right; i >= left; i--)
                matrix.get(bottom).set(i, elements.get(index++));

            // Left column
            for (int i = bottom - 1; i >= top + 1; i--)
                matrix.get(i).set(left, elements.get(index++));
        }

        // Print result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
