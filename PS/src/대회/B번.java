package 대회;

import java.io.*;
import java.util.*;
public class B번 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year[] = new int[3];
        Node solved[] = new Node[3];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            year[i] = b%100;
            solved[i] = new Node(a,str.charAt(0));
        }
        Arrays.sort(year);
        Arrays.sort(solved,(o1,o2)->{
            return o2.number - o1.number;
        });
        System.out.println(year[0]+""+year[1]+""+year[2]);
        System.out.println(solved[0].name+""+solved[1].name+""+solved[2].name);


    }
    static class Node{
        int number;
        char name;
        Node(int number,char name){
            this.number = number;
            this.name = name;
        }
    }
}
