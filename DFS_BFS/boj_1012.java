package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr ;

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row  =Integer.parseInt(st.nextToken());
			int col =Integer.parseInt(st.nextToken());
			int bae = Integer.parseInt(st.nextToken());
			arr = new int[row][col];

			for(int j=0;j<bae;j++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
			}

			int sum=0;

			for(int x=0;x<arr.length;x++) {
				for(int y=0;y<arr[0].length;y++) {
					if(arr[x][y]==1) {
						arr[x][y]=0;
						sum++;
						dfs(x,y);
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,-1,1};

	public static void dfs(int row,int col) {
		for(int i=0;i<4;i++) {
			int x = row+dx[i];
			int y = col+dy[i];

			if(x<0||y<0) continue;
			if(x>=arr.length||y>=arr[0].length) continue;

			if(arr[x][y]==1) {
				arr[x][y]=0;
				dfs(x,y);
			}
		}


	}
}


