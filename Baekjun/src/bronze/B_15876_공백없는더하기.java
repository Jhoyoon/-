package bronze;
import java.io.*;
import java.util.*;
public class B_15876_공백없는더하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length() == 4){
            // String a = str.substring(0, 2);
            // String b = str.substring(2, 4);
            // System.out.println(Integer.parseInt(a)+Integer.parseInt(b)); 
            System.out.println(20);   
        }else if(str.length()==3){
            if(str.charAt(2) == '0'){
                // String a=  str.substring(0, 1);
                // String b = str.substring(1, 3);
                // System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
                String a=  str.substring(0, 1);
                int b = 10;
                System.out.println(Integer.parseInt(a)+b);
            }else{
                // String a = str.substring(0, 2);
                // String b = str.substring(2, 3);
                // System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
                int a = 10;
                String b = str.substring(2, 3);
                System.out.println(a+Integer.parseInt(b));
            }
        }else{
            String a=  str.substring(0, 1);
            String b = str.substring(1, 2);
            System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
        }

    }
}