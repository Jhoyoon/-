package gold;
import java.io.*;
import java.util.*;
public class B_17298_오큰수{
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];
        int[] ans = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.add(1);
        for(int i=2;i<=N;i++){
            while(!myStack.isEmpty() && input[myStack.peek()]<input[i]){
                ans[myStack.pop()] = input[i];
            }
            myStack.add(i);
        }
        while(!myStack.isEmpty()){
            ans[myStack.pop()] = -1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            sb.append(ans[i]+" ");
        }
        System.out.println(sb.toString());
    }
}