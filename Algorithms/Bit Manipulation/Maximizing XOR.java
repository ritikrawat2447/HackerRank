import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maximizingXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int maximizingXor(int l, int r) {
    // Write your code here
        int Max = 0; 
        List<Integer> arr = new ArrayList<>();
        for ( int i=l ; i<=r ; i++){
            for ( int j=i ; j<=r ; j++ ){
                int res = i ^ j;
                arr.add(res);
                Max = Math.max(res, Max);
            }
        }
        // int Max = arr.get(0);
        // for ( int i=1; i<arr.size() ; i++){
        //     if ( Max < arr.get(i)){
        //         Max = arr.get(i);
        //     }
        // }
        return Max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.maximizingXor(l, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
