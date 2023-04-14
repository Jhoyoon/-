package gold;
import java.io.*;
import java.util.*;
public class B_17472_다리만들기 {
    // 좌표를 옮겨주는 애들
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    // 유니온 파인드에 사용하는 집합 배열
    static int[] parent;
    // 입력값을 저장할 map
    static int[][] map;
    static int N,M,sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist;
    static PriorityQueue<Edge17472> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 지도의 크기를 입력받는다
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 지도 정보를 저장할 2차원 배열
        map = new int[N][M];
        // 방문 여부 2차원 배열
        visited  = new boolean[N][M];
        // 방문 배열이랑 지도 배열 초기화
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                // 지도 이중 배열에 입력을 받음
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 
        sNum = 1;
        sumlist = new ArrayList<>();
        // 
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != 0 && visited[i][j] != true){
                    BFS(i,j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }
        // 최소신장트리 계산할 우선순위 큐 선언
        q = new PriorityQueue<>();

        for(int i=0;i<sumlist.size();i++){
            ArrayList<int[]> now = sumlist.get(i);
            for(int j=0;j<now.size();j++){
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_S = map[r][c];
                for(int d = 0;d<4;d++){
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int blenght = 0;
                    while(r+tempR >= 0 && r + tempR<N && c + tempC>= 0 && c+tempC<M){
                        if(map[r+tempR][c+tempC]==now_S) break;
                        else if(map[r+tempR][c+tempC] != 0){
                            if(blenght>1) q.add(new Edge17472(now_S, map[r+tempR][c+tempC], blenght));
                            break;
                        }else blenght++;
                        if(tempR < 0) tempR--;
                        else if(tempR>0) tempR++;
                        else if(tempC<0) tempC--;
                        else if(tempC>0) tempC++;
                    }
                }
            }
        }
        parent = new int[sNum];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while(!q.isEmpty()){
            Edge17472 now  = q.poll();
            if(find(now.start) != find(now.end)){
                union(now.start,now.end);
                result = result+now.dis;
                useEdge++;
            }
        }
        if(useEdge == sNum-2){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }
    private static int find(int a) {
        if(a==parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
    private static void union(int a,int b){
        a = find(a);
        b=find(b);
        if(a!=b){
            parent[b] = a;
        }
    }
    private static void BFS(int i,int j){
        // 넘겨줄 때 섬인 좌표들만 넘겨준다
        Queue<int[]> q = new LinkedList<>();
        mlist = new ArrayList<>();
        //탐색 시작좌표
        int[] start = {i,j};
        //큐에 시작 좌표를 넣어준다
        q.add(start);
        // mlist에도 시작 좌표를 추가해준다
        mlist.add(start);
        visited[i][j]=true;
        map[i][j] = sNum;
        while(!q.isEmpty()){
            //시작 좌표지 이게
            int now[] = q.poll();
            // i,j 좌표를 각각 꺼냄.row column
            int r = now[0];
            int c = now[1];
            //이제 각 좌표들ㅇ르 선회한다.
            for(int d=0;d<4;d++){
                int tempR = dr[d];
                int tempC = dc[d];
                // 좌표의 유효성 검사.각 좌표는 0보다는 같거나 커야하며 nm보다 하나 작아야한다
                while(r+tempR>=0 && r+tempR<N && c+tempC>=0 && c+tempC<M){
                    // 해당좌표를 방문한적 없고 바다가 아니라면
                    if(visited[r+tempR][c+tempC] == false && map[r+tempR][c+tempC]!=0){
                        addNode(r+tempR,c+tempC,q);
                        // while문에 대한 break. 해당 좌표로의 탐색을 중지한다
                    }else break;
                    // 진행방향의 끝까지 탐색하게 만드는 코드.while문 안에서 업데이트를 해주는구나
                    if(tempR<0) tempR--;
                    else if(tempR>0) tempR++;
                    else if(tempC<0) tempC--;
                    else if(tempC>0) tempC++;
                }
            }
        }
    }
    private static void addNode(int i,int j,Queue<int[]> q){
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp={i,j};
        mlist.add(temp);
        q.add(temp);

    }
}


class Edge17472 implements Comparable<Edge17472>{
    int start,end,dis;
    Edge17472(int start,int end,int dis){
        this.start = start;
        this.end = end;
        this.dis = dis;
    }
    public int compareTo(Edge17472 n){
        return this.dis - n.dis;
    }

    
}
