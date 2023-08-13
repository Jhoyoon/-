package baekjun.silver;
// import java.util.*;
// import java.io.*;
// public class B_14425_문자열찾기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N  = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         Node14425 root = new Node14425();

//         while(N>0){
//             st = new StringTokenizer(br.readLine());
//             String text = st.nextToken();
//             Node14425 now = root;
//             for(int i=0;i<text.length();i++){
//                 char c = text.charAt(i);
//                 if(now.next[c-'a']==null) now.next[c-'a'] = new Node14425();
//                 now = now.next[c-'a'];
//                 if(i==text.length()-1) now.isEnd = true;
//             }
//             N--;
//         }
//         int count = 0;
//         while(M>0){
//             st = new StringTokenizer(br.readLine()," ");
//             String text = st.nextToken();
//             Node14425 now = root;
//             for(int i=0;i<text.length();i++){
//                 char c = text.charAt(i);
//                 if(now.next[c-'a']==null) break;
//                 now = now.next[c-'a'];
//                 if(i==text.length()-1 && now.isEnd) count++;
//             }
//             M--;
//         }
//         System.out.println(count);
//     }
// }

// class Node14425{
//     Node14425[] next = new Node14425[26];
//     boolean isEnd;
// }

import java.io.*;
import java.util.*;

public class B_14425_문자열찾기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node14425 root = new Node14425();
        while(N>0){
            String text = br.readLine();
            Node14425 now = root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                if(now.next[c-'a']==null) now.next[c-'a'] = new Node14425();
                now = now.next[c-'a'];
                if(i==text.length()-1) now.isEnd = true;
            }
            N--;
        }
        int count = 0;
        while(M>0){
            String text = br.readLine();
            Node14425 now = root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                if(now.next[c-'a']==null) break;
                now = now.next[c-'a'];
                if(i==text.length()-1 && now.isEnd) count++;
            }
            M--;
        }
        System.out.println(count);
    }
}

class Node14425{
    Node14425[] next = new Node14425[26];
    boolean isEnd;
}