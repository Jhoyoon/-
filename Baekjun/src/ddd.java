import java.io.*;
import java.util.*;
public class ddd{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int N = st.countTokens();
    int[] a = new int[N];
    for(int i=0;i<N;i++){
      a[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(a);
    for(int i : a){
      System.out.print(i+" ");
    }
  }
}