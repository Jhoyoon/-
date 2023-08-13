package 대회;

import java.io.*;
import java.util.*;
public class A번 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if(A>B) System.out.println("Subway");
        else if(A<B) System.out.println("Bus");
        else System.out.println("Anything");
    }
}
