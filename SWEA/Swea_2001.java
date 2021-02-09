package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2001 {

	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[][]arr;
	public static void main(String[] args) throws NumberFormatException , IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int max=Integer.MIN_VALUE;
			for(int i=0;i<=n-m;i++) {
				for(int j=0;j<=n-m;j++) {
					max=Math.max(max,sum(i,j));
				}
			}
			
			sb.append("#"+tc+" "+max+"\n");
		}
		System.out.println(sb);
	}
	
	public static int sum(int x, int y) {
		int answer=0;
		for(int i=x;i<x+m;i++) {
			for(int j=y;j<y+m;j++) {
//				System.out.print(i+" "+j+" "+arr[i][j]+" //");
				answer+=arr[i][j];
			}
		}
		return answer;
	}

}
