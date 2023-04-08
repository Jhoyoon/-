package silver;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class B_10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(br.readLine());
            if(a!=0) st.add(a);
            else st.pop();
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        System.out.println(sum);

    }
}
