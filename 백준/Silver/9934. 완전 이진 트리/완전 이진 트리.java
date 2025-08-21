
import java.util.*;
import java.io.*;

class Main{
    static List<List<Integer>> tree = new LinkedList<>();
    static int k;
    public static void main (String[]args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());//높이
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int num = (int)Math.pow(2,k)-1;//전체 노드의 개수
        int[]arr = new int[num+1];
        for(int i=1;i<=num;i++){
            arr[i]=Integer.parseInt(st.nextToken());//중위순회한 결과 저장
        }
        for(int i=0;i<=k;i++)tree.add(new ArrayList<>());
        
        search(1,num,arr,1);
        
        for(int i=1;i<=k;i++){
            for(Integer e:tree.get(i)){
                System.out.print(e+" ");
            }
            System.out.println();
        }

        
    }
    public static void search(int start, int end, int[]arr,int depth){
        if(depth>k)return;
        int mid = (start+end)/2;
        tree.get(depth).add(arr[mid]);
        search(start,mid-1,arr,depth+1);
        search(mid+1,end,arr,depth+1);
    }
}