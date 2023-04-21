// package gold;


// import java.util.*;
// import java.io.*;

// public class B_1377{
//   public static void main(String[] args) throws IOException{
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     int n = Integer.parseInt(br.readLine());
//     Node[] arr = new Node[n];
//     for(int i=0;i<n;i++){
//       arr[i] = new Node(i,Integer.parseInt(br.readLine()));
//     }
//     Arrays.sort(arr,(o1,o2)->{
//       return o1.value-o2.value;
//     });
//     int max = 0;
//     for(int i=0;i<n;i++){
//       if(arr[i].index-i>max) max = arr[i].index-i;
//     }
//     System.out.println(max+1);




//   }
// }

// class Node{
//   int index;
//   int value;
//   Node(int index,int value){
//     this.index = index;
//     this.value = value;
//   }
// }
