package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_1874_스택수열{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> st = new Stack<>();
        int num = 1;
        boolean ss = true;
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            int now = arr[i];
            if(now >= num){
                while(now >= num){
                    st.push(num++);
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");
            }else{
                int n = st.pop();
                if(n == now){
                    sb.append("-\n");
                }else{
                    System.out.println("NO");
                    ss = false;
                    break;
                }
            }
        }
        if(ss) System.out.print(sb.toString());
    }
}
