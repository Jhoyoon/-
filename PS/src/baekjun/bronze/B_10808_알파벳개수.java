package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_10808_알파벳개수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] ans = new int[26];
        for(int i=0;i<ch.length;i++){
            ans[ch[i]-'a']++;;
        }
        StringBuffer sb = new StringBuffer();
        for(int i : ans){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
