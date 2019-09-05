import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> S = new Stack<Character>();
        char c,d;
        String ans="YES";
        for (int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(')    
                S.push(c);
            else {
                if(!S.isEmpty()) {
                d = S.pop();
                if(c=='}' && d != '{') {ans="NO"; break;}
                if(c==']' && d != '[') {ans="NO"; break;}
                if(c==')' && d != '(') {ans="NO"; break;}
                } else ans="NO";
            }
        }
        if(S.isEmpty()==false){
            ans="NO";
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter number of strings: ");
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            System.out.print("Enter String " + tItr+" : ");
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
