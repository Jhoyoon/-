package gold;
import java.io.*;
import java.util.*;
public class B_17298_오큰수{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] output = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> mySt = new Stack<>();
        for(int i=0;i<N;i++){
            while(!mySt.isEmpty() && input[mySt.peek()]<input[i]){
                output[mySt.pop()] = input[i];
            }
            mySt.push(i);
        }
        while(!mySt.isEmpty()){
            output[mySt.pop()] = -1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i : output){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}