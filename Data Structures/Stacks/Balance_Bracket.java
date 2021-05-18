import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> ans = new Stack<>();
        String answer = "NO";
        for( int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if ( ch == '{' || ch == '(' || ch == '[' ){
                ans.push(ch);
            }else{
                if ( ans.empty()){
                    return "NO";
                }
                char pop = ans.pop();
                if( ch == ')' && pop != '('){
                    return "NO";
                }
                else if( ch == ']' && pop != '['){
                    return "NO";
                }
                else if( ch == '}' && pop != '{'){
                    return "NO";
                }
                
            }
        }
        if ( ans.empty() ){
            return "YES";
        }else{
            return "NO";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
