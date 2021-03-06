import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n,int[][] queries) {
        
        // long newQueries[] = new long[n];  
        // for (int i=0; i<queries.length; i++ ){
        //     int x[] = queries[i];
        //     for (int j = (x[0] - 1); j < (x[1]); j++){
        //         newQueries[j] = newQueries[j] + x[2];
        //     }  
        // } 
        // long Max = newQueries[0];
        // for(int i=1 ; i<n; i++){
        //     if (Max < newQueries[i] ){
        //         Max = newQueries[i];
        //     }else{
        //         continue;
        //     }
        // }
        // return Max;
        long output[] = new long[n +2];
        for(int i=0 ; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            output[a] += k; 
            output[b+1] -= k;
        }
        long max = getMax(output);
        return max;
    }
    private static long getMax(long[] inputArray){
        long max = Long.MIN_VALUE;
        long sum = 0 ; 
        for(int i=0 ; i<inputArray.length; i++){
            sum += inputArray[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
