package silver;
import java.io.*;
import java.util.*;
public class B_14562_태권왕{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(DFS(a,b,0)+"\n");
        }
        System.out.print(sb.toString());
    }
    static int DFS(int a,int b,int count){
        if(a > b ) return 101;
        else if(a == b) return count;
        else{
            int min1 = DFS(a*2,b+3,count+1);
            int min2 = DFS(a+1,b,count+1);
            return Math.min(min1,min2);
        }
    }
}