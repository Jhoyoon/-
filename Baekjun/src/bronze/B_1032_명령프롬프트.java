package bronze;
import java.io.*;
import java.util.*;
public class B_1032_명령프롬프트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            str[i] = br.readLine();
        }
        for(int i=0;i<str[0].length();i++){
            boolean right = true;
            char c = str[0].charAt(i);
            for(int j=1;j<N;j++){
                if(c !=str[j].charAt(i)) right = false;
                c = str[j].charAt(i);
            }
            if(right) sb.append(c);
            else sb.append("?");
        }
        System.out.print(sb.toString());
    }
}
