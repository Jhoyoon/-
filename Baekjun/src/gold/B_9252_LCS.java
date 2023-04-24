package gold;
import java.io.*;
import java.util.*;
public class B_9252_LCS{
    static int[][] DP;
    static char[] A;
    static char[] B;
    static ArrayList<Character> path;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        DP = new int[A.length+1][B.length+1];
        path = new ArrayList<>();
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1] == B[j-1]) DP[i][j] = DP[i-1][j-1]+1;
                else DP[i][j]=Math.max(DP[i][j-1],DP[i-1][j]);
            }
        }
        StringBuffer sb  =new StringBuffer();
        sb.append(DP[A.length][B.length]+"\n");
        getText(A.length,B.length);
        for(int i= path.size()-1;i>=0;i--){
            sb.append(path.get(i));
        }
        System.out.print(sb.toString());
    }
    private static void getText(int a,int b){
        if(a == 0 || b == 0) return;
        if(A[a-1] == B[b-1]){
            path.add(A[a-1]);
            getText(a-1,b-1);
        }else{
            if(DP[a-1][b]>DP[a][b-1]){
                getText(a-1,b);
            }else{
                getText(a,b-1);
            }
        }
    }
}
