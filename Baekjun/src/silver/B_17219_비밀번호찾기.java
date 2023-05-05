package silver;

import java.io.*;
import java.util.*;

public class B_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String address = st.nextToken();
            String password = st.nextToken();
            map.put(address,password);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            String address = br.readLine();
            sb.append(map.get(address)+"\n");
        }
        System.out.print(sb.toString());

    }
}
