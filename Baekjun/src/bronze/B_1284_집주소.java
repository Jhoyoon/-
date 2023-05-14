package bronze;
import java.io.*;
import java.util.*;
public class B_1284_집주소 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            int sum = 2;
            int a = Integer.parseInt(br.readLine());
            if(a == 0) break;
            char[] c = String.valueOf(a).toCharArray();
            for(char i : c){
                if(i == '1'){
                    sum = sum + 2;
                }else if(i == '0'){
                    sum = sum + 4;
                }else{
                    sum = sum + 3;
                }
            }
            sum = sum + (c.length-1);
            sb.append(sum+"\n");
        }
        System.out.print(sb.toString());
    }
}
