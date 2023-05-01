import java.util.*;
import java.io.*;
import java.time.*;


public class ddd {
	public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr  = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    int count=0;
    for(int i=0;i<N;i++){
     int start = 0;
     int finish = N-1;
    int k = arr[i];
    while(finish>start){
      if(arr[finish]+arr[start]>k){
        finish--;
      }else if(arr[finish]+arr[start]<k){
        start++;
      }else{
        if(start!=i && finish!=i){
          count++;
          break;
        }else if(start == i) start++;
        else if(finish==i) finish--;
      }
    }
   }
   System.out.println(count);
  }
}