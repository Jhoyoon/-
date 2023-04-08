package silver;
import java.util.*;
import java.io.*;
public class B_1931_회의실배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node_1931[] arr = new Node_1931[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i] =new Node_1931(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr,(o1,o2)->{
            if(o1.e==o2.e) return o1.s-o2.s;
            else return o1.e-o2.e;
        });
        int count = 0;
        int finish= 0;
        for(int i=0;i<N;i++){
            if(arr[i].s>=finish){
                count++;
                finish= arr[i].e;
            }
        }
        System.out.println(count);
    }
}
class Node_1931{
    int s;
    int e;
    Node_1931(int s,int e){
        this.s = s;
        this.e=e;
    }
}
