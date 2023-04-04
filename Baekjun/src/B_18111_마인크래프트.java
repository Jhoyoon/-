// import java.util.*;
// import java.io.*;
// public class B_18111_마인크래프트{
//     public static void main(String[] args)throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int B = Integer.parseInt(st.nextToken());
//         int[][] arr = new int[N][M];
//         int low = 256;
//         int hi = 0;
//         for(int i=0;i<N;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             for(int j=0;j<M;j++){
//                 arr[i][j] = Integer.parseInt(st.nextToken());
//                 if(arr[i][j]<low) low = arr[i][j];
//                 if(arr[i][j]>hi) hi = arr[i][j];
//             }
//         }
//         int time = Integer.MAX_VALUE;
//         int high = 0;

//         for(int i=low;i<=hi;i++){
//             int count = 0;
//             int block = B;
//             for(int j=0;j<N;j++){
//                 for(int k=0;k<M;k++){
//                     if(arr[j][k]>i){
//                         count=count+(arr[j][k]-i)*2;
//                         block = block+(arr[j][k]-i);
//                     }else if(arr[j][k]<i){
//                         count=count +(i-arr[j][k]);
//                         block = block-(i-arr[j][k]);
//                     }
//                 }
//             }
//             if(block<0) break;

//             if(time>=count){
//                 time = count;
//                 high=i;
//             }
            
//         }
//         System.out.println(time+" "+high);


//     }
// }

import java.util.*;
import java.io.*;

public class B_18111_마인크래프트{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr=  new int[N][M];
        int max = 0;
        int low = 256;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
                if(arr[i][j]>max) max = arr[i][j];
                if(arr[i][j]<low) low = arr[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;
        for(int i=low;i<=max;i++){
            int count = 0;
            int block = B;
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[j][k]>i){
                        count = count+(arr[j][k]-i)*2;
                        block = block + (arr[j][k]-i);
                    }else if(arr[j][k]<i){
                        count = count+(i-arr[j][k]);
                        block = block + (i-arr[j][k]);
                    }
                }
            }
            if(block<0) break;

            if(count<= time){
                time = count;
                high=i;
            }
        }
        System.out.println(time+" "+high);
    }
}