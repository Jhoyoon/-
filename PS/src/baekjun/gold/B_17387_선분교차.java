package baekjun.gold;
// import java.io.*;
// import java.util.*;
// public class B_17387_선분교차{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         long x1,y1,x2,y2,x3,y3,x4,y4;
//         x1 = Long.parseLong(st.nextToken());
//         y1 = Long.parseLong(st.nextToken());
//         x2 = Long.parseLong(st.nextToken());
//         y2 = Long.parseLong(st.nextToken());

//         st = new StringTokenizer(br.readLine()," ");
//         x3 = Long.parseLong(st.nextToken());
//         y3 = Long.parseLong(st.nextToken());
//         x4 = Long.parseLong(st.nextToken());
//         y4 = Long.parseLong(st.nextToken());
//         boolean cross = isCross(x1,y1,x2,y2,x3,y3,x4,y4);
//         if(cross) System.out.println(1);
//         else System.out.println(0);
//     }
//     private static boolean isCross(long x1,long y1,long x2,long y2,long x3,long y3,long x4,long y4){
//         long abc = CCW(x1,y1,x2,y2,x3,y3);
//         long abd = CCW(x1,y1,x2,y2,x4,y4);
//         long cda = CCW(x3,y3,x4,y4,x1,y1);
//         long cdb = CCW(x3,y3,x4,y4,x2,y2);
//         if(abc*abd == 0 && cda*cdb==0) return isOverlab(x1,y1,x2,y2,x3,y3,x4,y4);
//         else if(abc*abd<=0 && cda*cdb<=0) return true;
//         else return false;
//     }
//     private static long CCW(long x1,long y1,long x2,long y2,long x3,long y3){
//         long tmp = (x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3);
//         if(tmp>0) return 1;
//         else if(tmp<0) return -1;
//         else return 0;
//     }
//     private static boolean isOverlab(long x1,long y1,long x2,long y2,long x3,long y3,long x4,long y4){
//         if(Math.min(x1,x2) <= Math.max(x3,x4) && Math.min(y1,y2)<=Math.max(y3,y4) && Math.min(x3,x4)<=Math.max(x1,x2) && Math.min(y3,y4)<=Math.max(y1,y2)) return true;
//         else return false;
//     }
// }
import java.io.*;
import java.util.*;
public class B_17387_선분교차{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long x1,y1,x2,y2,x3,y3,x4,y4;
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        x3 = Long.parseLong(st.nextToken());
        y3 = Long.parseLong(st.nextToken());
        x4 = Long.parseLong(st.nextToken());
        y4 = Long.parseLong(st.nextToken());

        boolean cross = isCross(x1,y1,x2,y2,x3,y3,x4,y4);
        if(cross) System.out.println(1);
        else System.out.println(0);
    }
    private static boolean isOverlab(long x1,long y1,long x2,long y2,long x3,long y3,long x4,long y4){
        if(Math.min(x1,x2)<=Math.max(x3,x4) && Math.min(x3,x4)<=Math.max(x1,x2) && Math.min(y1,y2)<=Math.max(y3,y4) && Math.min(y3,y4)<=Math.max(y1,y2)) return true;
        else return false;
    }
    private static long CCW(long x1,long y1,long x2,long y2,long x3,long y3){
        long tmp  = ( x1*y2 + x2*y3 + x3*y1 ) - (x2*y1+x3*y2+x1*y3);
        if(tmp>0) return 1;
        else if(tmp<0) return -1;
        else return 0;
    }
    private static boolean isCross(long x1,long y1,long x2,long y2,long x3,long y3,long x4,long y4){
        long abc = CCW(x1,y1,x2,y2,x3,y3);
        long abd = CCW(x1,y1,x2,y2,x4,y4);
        long cda = CCW(x3,y3,x4,y4,x1,y1);
        long cdb = CCW(x3,y3,x4,y4,x2,y2);

        if(abc * abd == 0 && cda * cdb == 0){
            return isOverlab(x1,y1,x2,y2,x3,y3,x4,y4);
        }else if(abc*abd <= 0 && cda*cdb <= 0){
            return true;
        }else{
            return false;
        }
    }
}