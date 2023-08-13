package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_2605_줄세우기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) arr.add(i+1);
            else arr.add(arr.size()-num,i+1);
        }
        StringBuffer sb = new StringBuffer();
        for(int i : arr){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}