package bronze;
import java.io.*;
import java.util.*;
public class B_25494_단순한문제 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int i=1;i<=a;i++){
                for(int j=1;j<=b;j++){
                    for(int k=1;k<=c;k++){
                        if(i%j == j%k && i%j == k%i && j%k == k%i){
                            count++;
                        }
                    }
                }
            }
            sb.append(count+"\n");
            count = 0;
        }
        System.out.print(sb.toString());
    }
}
