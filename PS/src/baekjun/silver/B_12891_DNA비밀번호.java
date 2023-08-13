package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_12891_DNA비밀번호{
    static int[] checkArr;
    static int[] myArr;
    static int count;
    static int check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] c = br.readLine().toCharArray();
        checkArr = new int[4];
        myArr = new int[4];
        st = new StringTokenizer(br.readLine()," ");
        check = 0;
        for(int i=0;i<4;i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) check++;
        }
        count = 0;
        for(int i=0;i<M;i++){
            Add(c[i]);
        }
        if(check == 4) count++;
        int start_index = 0;
        int end_index = M;
        while(end_index < N){
            Add(c[end_index]);
            Remove(c[start_index]);
            if(check == 4) count++;
            start_index++;
            end_index++;
        }
        System.out.println(count);
    }
    private static void Remove(char c){
        switch(c){
            case 'A':
                if(checkArr[0] == myArr[0]) check--;
                myArr[0]--;
                break;
            case 'C':
                if(checkArr[1] == myArr[1]) check--;
                myArr[1]--;
                break;
            case 'G':
                if(checkArr[2] == myArr[2]) check--;
                myArr[2]--;
                break;
            case 'T':
                if(checkArr[3] == myArr[3]) check--;
                myArr[3]--;
                break;
        }
    }
    private static void Add(char c){
        // a c g t
        switch(c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) check++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) check++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) check++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) check++;
                break;
        }
    }
}