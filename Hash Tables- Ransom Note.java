import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0; i < magazine.length; i++){
            if(map.containsKey(magazine[i])){
               map.put(magazine[i], map.get(magazine[i]) + 1);
            }
            else{
                map.put(magazine[i], 1);
            }
        }
        for (int i=0; i < ransom.length; i++){
            if(map.containsKey(ransom[i])){
               if (map.get(ransom[i]) > 0){
                 map.put(ransom[i], map.get(ransom[i]) - 1);
               }
               else{
                 System.out.print("No");
                 return;
               }
            }
            else{
                 System.out.print("No");
                 return;
            }
        }
        System.out.print("Yes");
        return;
    }
}