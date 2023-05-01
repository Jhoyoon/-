package gold;
import java.io.*;
import java.util.*;
public class B_17298_오큰수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];
        int[] answer = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> myst = new Stack<>();
        myst.push(1);
        for(int i=2;i<=N;i++){
            while(!myst.isEmpty() && input[myst.peek()] <input[i]){
                answer[myst.pop()] = input[i];
            }
            myst.push(i);
        }
        while(!myst.isEmpty()){
            answer[myst.pop()] = -1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            sb.append(answer[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
