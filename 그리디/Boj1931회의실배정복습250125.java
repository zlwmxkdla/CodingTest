package 그리디;
import java.io.*;
import java.util.*;
public class Boj1931회의실배정복습250125 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int[][]arr = new int[num][2];

		for(int i=0;i<num;i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		int count = 0;
		int end = -1;
		for(int i=0;i<num;i++) {
			if(arr[i][0]>=end) {
				end=arr[i][1];
				count+=1;
			}
		}
		System.out.println(count);
	}
}
