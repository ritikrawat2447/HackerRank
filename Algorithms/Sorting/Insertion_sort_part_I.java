import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
        int search = arr.get(n-1);
        // for ( int i= n-1 ; i>0 ; i--){
            
        //     if( arr.get(i-1) > search ){
        //         arr.set(i , arr.get(i-1));
        //     }
        //     else {
        //         arr.set( i , search);
        //         i = 0 ; 
        //     }
        //     for ( int j=0 ; j< n ; j++){
        //         System.out.print(arr.get(j) + " ");
        //     }
        //     System.out.println();
            
        //     if ( i-1 == 0 && arr.get(0) > search ){
        //         arr.set( i , arr.get( i ));
        //         arr.set( 0 , search );
        //         for ( int j=0 ; j< n ; j++){
        //         System.out.print(arr.get(j) + " ");
        //         }
        //     }
        // }
        int i = arr.size() - 1 ;
        while ( i > 0 && arr.get( i-1 ) > search  ){
            arr.set( i , arr.get(i-1));
            for ( int j=0 ; j<arr.size() ; j++){
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
            i--; 
        }
        arr.set(i , search );
        for ( int j=0 ; j<arr.size() ; j++){
            System.out.print(arr.get(j) + " ");
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
