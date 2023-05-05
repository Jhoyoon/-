package silver;
import java.io.*;
import java.util.*;
public class B_1620_포켓몬마스터 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> set = new HashMap<>();
        String[] str = new String[N+1];
        for(int i=1;i<=N;i++){
            String name = br.readLine();
            set.put(name,i);
            str[i] = name;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=M;i++){
            String str2 = br.readLine();
            try{
                Double.parseDouble(str2);
                int key = Integer.parseInt(str2);
                sb.append(str[key]+"\n");
            }catch(NumberFormatException e){
                sb.append(set.get(str2)+"\n");

            }
        }
        System.out.print(sb.toString());
    }
}
