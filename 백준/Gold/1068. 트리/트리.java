import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static List<List<Integer>> list;
    static int root;
    static boolean[]visited;
    static int answer=0;
    public static void main(String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N;i++)list.add(new LinkedList<>());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent!=-1){
                list.get(parent).add(i);
            }else{
                root=i;
            }
        }
        visited = new boolean[N];
        
        int delete = Integer.parseInt(bf.readLine());
        if(delete==root){
            System.out.println(0);
            return;
        }
        findLeaf(delete, root);
        System.out.println(answer);
    }
    public static void findLeaf(int delete, int node){
        visited[node]=true;
        //리프노드인 경우
        if(list.get(node).size()==0)answer+=1;
        for(Integer e:list.get(node)){
            if(e==delete&&list.get(node).size()==1){
                answer+=1;
                visited[e]=true;
                continue;
            }
            if(e==delete){
                visited[e]=true;
                continue;//삭제된 노드라면 탐색 건너뛰기
            }
            if(!visited[e]){
                visited[e]=true;
                findLeaf(delete,e);
            }
        }
    }
}
