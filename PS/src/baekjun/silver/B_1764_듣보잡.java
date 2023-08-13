package baekjun.silver;
import java.io.*;
import java.util.*;

public class B_1764_듣보잡 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        StringBuffer sb = new StringBuffer();
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<M;i++){
            String tmp = br.readLine();
            if(set.contains(tmp)){
                ans.add(tmp);
            } 
        }
        Collections.sort(ans);
        sb.append(ans.size()+"\n");
        for(String i : ans){
            sb.append(i+"\n");
        }
        System.out.print(sb.toString());
    }
}
