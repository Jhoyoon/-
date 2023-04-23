package gold;
import java.io.*;
import java.util.StringTokenizer;
public class B_13398_연속합2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] or = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            or[i] = Integer.parseInt(st.nextToken());
        }
        long[] L = new long[N+1];
        long[] R = new long[N+1];
        long result = or[1];
        L[1] = or[1];
        for(int i=2;i<=N;i++){
            L[i] = Math.max(or[i],L[i-1]+or[i]);
            result = Math.max(result,L[i]);
        }
        R[N] = or[N];
        for(int i=N-1;i>=1;i--){
            R[i] = Math.max(or[i],R[i+1]+or[i]);
        }
        for(int i=2;i<N;i++){
            long tmp = L[i-1]+R[i+1];
            result=Math.max(tmp,result);
        }
        System.out.print(result);

    }
}