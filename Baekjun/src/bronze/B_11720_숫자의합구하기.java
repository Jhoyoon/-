package bronze;
import java.io.*;
import java.util.*;
public class B_11720_숫자의합구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        int ans = 0;
        for(int i=0;i<ch.length;i++){
            ans+= ch[i]-'0';
        }
        System.out.println(ans);

    }
}
