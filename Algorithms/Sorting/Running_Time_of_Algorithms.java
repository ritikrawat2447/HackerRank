import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int runningTime(List<Integer> arr) {
        int count = 0;
        for ( int i=1 ; i< arr.size() ;  i++){
            int temp = arr.get(i);
            int j = i-1 ; 
            while ( j >=0 && arr.get(j) > temp ){
                arr.set( j + 1, arr.get(j));
                j--;
                count++;
            }
            arr.set( j+1 , temp );
            // int k = i ; 
            // while ( k < arr.size() - 1 && ans == true  ){
            //     if ( arr.get(k) < arr.get(k+1) ){
            //         ans = true ; 
            //     }else{
            //         ans = false ; 
            //         count ++ ;
            //     }
            //     k++;
            // }
            // if ( ans == true ){
            //     break;
            // }
        }
        return count ;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
