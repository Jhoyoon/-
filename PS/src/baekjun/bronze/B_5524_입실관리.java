package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_5524_입실관리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            char[] ch = br.readLine().toCharArray();
            for(int j=0;j<ch.length;j++){
                if(ch[j] >= 'A' && ch[j] <= 'Z'){
                    //ch[j]=(char)(ch[j] +32);
                    ch[j] = Character.toLowerCase(ch[j]);
                }
                sb.append(ch[j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

        
    }
}
