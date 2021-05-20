import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code here
        int min = 0;
        int a[] = new int[26];
        int b[] = new int[26];
        
        for( int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            int chh = (int)ch;
            int pos = chh - (int)'a';
            a[pos]++ ;
        }
        for( int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            int chh = (int)ch;
            int pos = chh - (int)'a';
            b[pos]++ ;
        }
        for ( int i=0 ; i<26; i++){
            int diff = Math.abs(a[i] - b[i]);
            min += diff;
        }
        return min;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
