import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        int count = 0;
        int speacial = 0;
        int uppercase = 0;
        int lowercase = 0;
        int number = 0;
        for ( int i=0; i<password.length(); i++){
            int ch =(char)password.charAt(i); 
            if ( ch >= 48 && ch <= 57 ){
                number++;
            }else if( ch >= 65 && ch <= 90){
                uppercase++;
            }else if( ch >= 97 && ch <= 122){
                lowercase++;
            }else {
                speacial++;
            }
        }
        if ( number == 0){
            count++;
        }
        if ( uppercase == 0){
            count++;
        }
        if( lowercase == 0){
            count++;
        }
        if ( speacial == 0){
            count++;
        }
        
        if( password.length()+count>=6){
            return count ;
        }else{
            int ans = count+(6-(password.length() + count));
            return ans;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
 
