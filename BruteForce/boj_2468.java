import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static PriorityQueue<Integer> q = new PriorityQueue<>();
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr =new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(!q.contains(arr[i][j])){
					q.add(arr[i][j]);
				}
			}
		}
		int answer=1;
		while(!q.isEmpty()){
			answer=Math.max(answer,sink(q.poll()));
		}
		System.out.println(answer);
	}

	public static int sink(int area) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]<=area) {
					arr[i][j]=0;
				}
			}
		}
		int cnt=0;
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]>0&&!visited[i][j]) {
					connection(i,j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	static int[]dx = {0,0,-1,1};
	static int[]dy = {-1,1,0,0};
	public static void connection(int i,int j) {
        visited[i][j]=true;
		for(int k=0;k<4;k++) {
			int x = dx[k]+i;
			int y = dy[k]+j;
			if(x<0 || y<0 || x>=n || y>=n) continue;
			if(arr[x][y]>0&&!visited[x][y]) {
				connection(x,y);
			}
		}
	}
}
