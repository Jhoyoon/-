package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_15886_내선물을받아줘2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        int count = 0;
        for(int i=1;i<N;i++){
            if(c[i-1] == 'E' && c[i] == 'W'){
                count++;
            }
        }
        System.out.println(count);
    }
}
