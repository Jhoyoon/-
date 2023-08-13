package 대회;

import java.io.*;
import java.util.*;

public class D번 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Node[] arr = new Node[N];
        // 이동한 거리 저장하는 배열
        int[] distance = new int[N];
        for(int i=0;i<N;i++){
            arr[i] =new Node(Integer.parseInt(st.nextToken()),i);
        }
        // 선택정렬 알고리즘
        for(int i=0;i<N;i++){
            int min = i;
            for(int j=i+1;j<N;j++){
                if(arr[min].value > arr[j].value) min = j;
            }
            if(arr[min].value < arr[i].value){
                // 이동한 거리를 distance 거리에 저장하는 코드.이동할 요소들 index 차를 해당하는 distance 배열에 더해줌. 
                distance[arr[min].index] = distance[arr[min].index] + (arr[min].index - arr[i].index);
                distance[arr[i].index] = distance[arr[i].index] + (arr[min].index - arr[i].index);
                // 그리고 뒤로 날라온 요소의 index를 날아온 자리 index로 바꿔줌
                arr[i].index = arr[min].index;
                Node tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        StringBuffer sb  =new StringBuffer();
        for(int i=0;i<N;i++){
            sb.append(distance[i]+" ");
        }
        System.out.print(sb.toString());
    }
    static class Node {
        int value;
        int index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

    

