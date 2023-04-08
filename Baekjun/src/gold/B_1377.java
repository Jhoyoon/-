package gold;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.nio.BufferOverflowException;
// import java.util.*;
// import java.io.*;

// public class B_1377 {
//     public static void main(String[] args) throws IOException{
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       int N = Integer.parseInt(br.readLine());
//       Node[] arr = new Node[N];
//       for(int i=0;i<N;i++){
//         arr[i] = new Node(i,Integer.parseInt(br.readLine()));
//       }
//       Arrays.sort(arr);
//       int max = 0;
//       for(int i=0;i<N;i++){
//         if(arr[i].index - i>max) max = arr[i].index-i;
//       }
      
//       System.out.println(max+1);

//   }    
// }

// class Node implements Comparable<Node>{
//   public int index;
//   public int value;

//   Node(int index,int value){
//     super();
//     this.index = index;
//     this.value = value;
//   }
  
//   public int compareTo(Node o){
//     return this.value - o.value;
//   }
// }

import java.util.*;
import java.io.*;

public class B_1377{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Node[] arr = new Node[n];
    for(int i=0;i<n;i++){
      arr[i] = new Node(i,Integer.parseInt(br.readLine()));
    }
    Arrays.sort(arr,(o1,o2)->{
      return o1.value-o2.value;
    });
    int max = 0;
    for(int i=0;i<n;i++){
      if(arr[i].index-i>max) max = arr[i].index-i;
    }
    System.out.println(max+1);




  }
}

class Node{
  int index;
  int value;
  Node(int index,int value){
    this.index = index;
    this.value = value;
  }
}
