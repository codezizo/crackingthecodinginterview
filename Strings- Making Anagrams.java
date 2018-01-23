import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
      HashMap<Character,Integer> hashA = new HashMap<Character,Integer>();
      int deleteCount = 0;
      for (int i=0; i < first.length(); i++){
          if (hashA.containsKey(first.charAt(i))){
            hashA.put(first.charAt(i), hashA.get(first.charAt(i)) + 1);
          }
          else{
            hashA.put(first.charAt(i), 1);
          }
      }
      for (int i=0; i < second.length(); i++){
          if (hashA.containsKey(second.charAt(i))){
             if (hashA.get(second.charAt(i)) > 0){
                hashA.put(second.charAt(i), hashA.get(second.charAt(i)) - 1);
             }
             else{
                hashA.remove(second.charAt(i)); 
                deleteCount++;
             }
          }
          else{
              deleteCount++;
          }
      }
     for (Integer value : hashA.values()) {
         if (value > 0){
           deleteCount = deleteCount + value;  
         }
     }
     return deleteCount;
  }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
