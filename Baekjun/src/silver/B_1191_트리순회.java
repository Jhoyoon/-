package silver;
// import java.util.*;
// import java.io.*;
// public class B_1191_트리순회 {
//     static int[][] tree;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         sc.nextLine();
//         tree = new int[26][2];
//         for(int i=0;i<N;i++){
//             String[] temp = sc.nextLine().split(" ");
//             int node = temp[0].charAt(0)-'A';
//             char left = temp[1].charAt(0);
//             char right = temp[2].charAt(0);
//             if(left=='.') tree[node][0] = -1;
//             else tree[node][0] = left-'A';
//             if(right == '.') tree[node][1] = -1;
//             else tree[node][1] = right-'A';
//         }
//         postOrder(0);
//         System.out.println();
//         inOrder(0);
//         System.out.println();
//         preOrder(0);
//         System.out.println();
//     }
//     private static void postOrder(int now) {
//         if(now==-1) return;
//         System.out.print((char)(now+'A'));
//         postOrder(tree[now][0]);
//         postOrder(tree[now][1]);
//     }
//     private static void inOrder(int now) {
//         if(now==-1) return;
//         inOrder(tree[now][0]);
//         System.out.print((char)(now+'A'));
//         inOrder(tree[now][1]);

//     }
//     private static void preOrder(int now) {
//         if(now==-1) return;
//         preOrder(tree[now][0]);
//         preOrder(tree[now][1]);
//         System.out.print((char)(now+'A'));
//     }
// }
import java.util.*;
import java.io.*;
public class B_1191_트리순회{
    static int[][] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int node = st.nextToken().charAt(0)-'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left == '.') tree[node][0] = -1;
            else tree[node][0] = left-'A';
            if(right=='.') tree[node][1] = -1;
            else tree[node][1] = right-'A';
        }
        first(0);
        System.out.println();
        second(0);
        System.out.println();
        third(0);
    }
    private static void first(int now){
        if(now == -1) return;
        System.out.print((char)(now+'A'));
        first(tree[now][0]);
        first(tree[now][1]);
    }
    private static void second(int now){
        if(now == -1) return;
        second(tree[now][0]);
        System.out.print((char)(now+'A'));
        second(tree[now][1]);
    }
    private static void third(int now){
        if(now == -1) return;
        third(tree[now][0]);
        third(tree[now][1]);
        System.out.print((char)(now+'A'));
    }
}