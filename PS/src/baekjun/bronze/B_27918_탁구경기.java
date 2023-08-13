package baekjun.bronze;
import java.io.*;
public class B_27918_탁구경기  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d = 0;
        int p  =0;
        for(int i=0;i<N;i++){
            String s =  br.readLine();
            if(s.equals("D")) d++;
            if(s.equals("P")) p++;
            if(Math.abs(d-p)>=2 || Math.abs(p-d)>=2) break;
        }
        System.out.print(d+":"+p);
    }
}
