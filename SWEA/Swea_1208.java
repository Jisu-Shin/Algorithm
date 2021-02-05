package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1208  {

	static StringBuilder sb = new StringBuilder();
	static final int size=100;
	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1;i<=10;i++) {
			
			int diff=0;
			int cnt = Integer.parseInt(br.readLine());			
			
			int[] arr = new int[size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			
			
			while(true) {
				Arrays.sort(arr);
				//평탄화완료 or 모든 덤프횟수 다할때까지
				if(arr[99]-arr[0]<=1 || cnt==0 ) {
					diff=arr[99]-arr[0];
					break;
				}
				
				//계속 dump
				cnt--;
				arr[99]--;
				arr[0]++;
				
				
			}
			sb.append("#"+i+" "+diff+"\n");
			
		}
		System.out.println(sb);
	}

}
