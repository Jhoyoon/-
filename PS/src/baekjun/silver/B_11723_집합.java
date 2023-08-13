package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_11723_집합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            int a = 0;
            if(!str.equals("all") && !str.equals("empty")){
                a = Integer.parseInt(st.nextToken());
            }
            switch(str){
                case "add":
                    if(set.contains(a)) break;
                    else{
                        set.add(a);
                        break;
                    }
                case "remove":
                    if(set.contains(a)){
                        set.remove(a);
                        break;
                    }else{
                        break;
                    }
                case "check":
                    if(set.contains(a)){
                        sb.append(1+"\n");
                        break;
                    }else{
                        sb.append(0+"\n");
                        break;
                    }
                case "toggle":
                    if(set.contains(a)){
                        set.remove(a);
                        break;
                    }else{
                        set.add(a);
                        break;
                    }
                case "all":
                    set.clear();
                    for(int j=1;j<=20;j++){
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();;
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
