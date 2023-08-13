package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_1043_거짓말{
  static int[] parent;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int personNum = Integer.parseInt(st.nextToken());
    int partyNum = Integer.parseInt(st.nextToken());
    // 여기까지해서 첫번째 줄 입력 받음
    parent = new int[personNum+1];
    for(int i=1;i<=personNum;i++){
      parent[i] = i;
    }
    ArrayList<Integer>[] party = new ArrayList[partyNum];
    st = new StringTokenizer(br.readLine()," ");
    int truePersonNum = Integer.parseInt(st.nextToken());
    int[] truePerson = new int[truePersonNum];
    for(int i=0;i<truePersonNum;i++){
      truePerson[i] = Integer.parseInt(st.nextToken());
    }
    // 여기까지 진실을 아는 사람들 입력 받음
    // 이제 각 파티 참석자
    for(int i=0;i<partyNum;i++){
      st = new StringTokenizer(br.readLine()," ");
      int partySize = Integer.parseInt(st.nextToken());
      party[i] = new ArrayList<>();
      for(int j=0;j<partySize;j++){
        party[i].add(Integer.parseInt(st.nextToken()));
      }
    }
    for(int i=0;i<partyNum;i++){
      int firstPerson = party[i].get(0);
      for(int j=1;j<party[i].size();j++){
        union(firstPerson,party[i].get(j));
      }
    }
    int result = 0;
    for(int i=0;i<partyNum;i++){
      boolean check= true;
      int get = find(party[i].get(0));
      for(int j=0;j<truePersonNum;j++){
        if(get == find(truePerson[j])){
          check = false;
          break;
        }
      }
      if(check) result++;
    }
    System.out.println(result);
  }
  private static void union(int a,int b){
    a = find(a);
    b = find(b);
    if(a!=b){
      if(a > b) parent[a] = b;
      else parent[b] =a;
    }
  }
  private static int find(int a){
    if(a == parent[a]) return a;
    else return parent[a]=find(parent[a]);
  }
}