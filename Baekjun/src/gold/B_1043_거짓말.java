package gold;

// import java.io.*;
// import java.util.*;

// public class B_1043_거짓말{
//   static int[] parent;
//   static ArrayList<Integer>[] party;
//   static int[] trueP;
//   public static void main(String[] args){
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt();
//     int M = sc.nextInt();
//     int truePerson = sc.nextInt();
//     int result = 0;

//     parent = new int[N+1];
//     for(int i=1;i<=N;i++){
//       parent[i] = i;
//     }
//     trueP = new int[truePerson+1];
//     for(int i=1;i<=truePerson;i++){
//       trueP[i] = sc.nextInt();
//     }
//     party = new ArrayList[M+1];
//     for(int i=1;i<=M;i++){
//       party[i] = new ArrayList<>();
//     }
//     // party 어레이 입력 받음
//     for(int i=1;i<=M;i++){
//       int partyPerson = sc.nextInt();
//       for(int j=0;j<partyPerson;j++){
//         party[i].add(sc.nextInt());
//       }
//     }
//     // 각 파티에 참석한 인원들을 전부 하나의 집합에 묶어준다.
//     for(int i=1;i<=M;i++){
//       int firstPerson = party[i].get(0);
//       for(int j=1;j<party[i].size();j++){
//         union(firstPerson,party[i].get(j));
//       }
//     }
//     // 진실을 아는 사람들이 해당 합집합에 속해있다면 그 파티는 과장할수 없는 파티다
//     for(int i=1;i<=M;i++){
//       boolean check  =true;
//       int firstParty = find(party[i].get(0));
//       for(int j = 1;j<=truePerson;j++){
//         if (firstParty == find(trueP[j])){
//           check = false;
//           break;
//         }
//       }
//       if(check) result++;
//     }
//     System.out.print(result);

//   }
//   private static void union(int a,int b){
//     a = find(a);
//     b = find(b);
//     if(a!=b){
//       parent[b]=a;
//     }
//   }
//   private static int find(int a){
//     if(a == parent[a]) return a;
//     else return parent[a]=find(parent[a]);
//   }
// }

import java.util.*;

public class B_1043_거짓말{
  static int[] truePerson;
  static int[] parent;
  static ArrayList<Integer>[] party;
  public static void main(String[] args){
    // 사람 명수와 파티 개수 입력 받음
    // 진실을 아는 사람들의 숫자와 그들의 번호를 입력받음
    // 각 파티에 참석하는 사람들을 입력 받음
    // 같은 파티에 참석하는 사람들을 같은 집합으로 묶어줌
    // 진실을 아는 사람들중 각 파티의 집합에 속하는 사람들이 있다면 그 피타는 과장할수 없는 파티임
    // 진실을 아는 사람의 대표 노드와 그 파티 첫번째 참석자의 대표 노드가 일치하는지 확인.하나라도 일치한다면 그 파티는 참석 못 함
    Scanner sc = new Scanner(System.in);
    // 사람 명수
    int N = sc.nextInt();
    //파티 개수
    int M = sc.nextInt();
    int trueNumber = sc.nextInt();
    truePerson  = new int[trueNumber+1];
    for(int i=1;i<=trueNumber;i++){
      truePerson[i] = sc.nextInt();
    }
    //파티 배열
    party = new ArrayList[M+1];
    for(int i=1;i<=M;i++){
      party[i] = new ArrayList<>();
      int partyN = sc.nextInt();
      for(int j=0;j<partyN;j++){
        party[i].add(sc.nextInt());
      }
    }

    parent = new int[N+1];
    for(int i=1;i<=N;i++){
      parent[i] = i;
    }

    for(int i=1;i<=M;i++){
      int firstP = party[i].get(0);
      for(int j=0;j<party[i].size();j++){
        union(firstP,party[i].get(j));
      }
    }

    int result = 0;
    for(int i=1;i<=M;i++){
      boolean check = true;
      int partyN = find(party[i].get(0));
      for(int j=1;j<=trueNumber;j++){
        if(partyN==find(truePerson[j])) {
          check = false;
          break;
      }
    }
    if(check) result++;
  }
    System.out.print(result);
  }
  private static void union(int a,int b){
    a = find(a);
    b = find(b);
    if(a!=b) parent[b] = a;
  }
  private static int find(int a){
    if(a == parent[a]) return a;
    else return parent[a]= find(parent[a]);
  }
}