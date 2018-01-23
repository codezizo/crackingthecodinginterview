import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new <Character>Stack();
        HashMap<Character, Character> open_to_close_map = new <Character, Character>HashMap();
        open_to_close_map.put('{','}');
        open_to_close_map.put('(',')');
        open_to_close_map.put('[',']');
        
        HashMap<Character, Character> close_to_open_map = new <Character, Character>HashMap();
        close_to_open_map.put('}','{');
        close_to_open_map.put(')','(');
        close_to_open_map.put(']','[');
        
        for(int i=0; i < expression.length(); i++){
           char input_char = expression.charAt(i);
           if (open_to_close_map.containsKey(input_char)){
               stack.push(input_char);
           }
           else if (stack.empty()){
               return false;
           } 
           else if (stack.peek() == close_to_open_map.get(input_char)){
               stack.pop();
           }
           else{
               return false;
           }    
        }
        if (!stack.empty()){
           return false;
        }
        return true;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
