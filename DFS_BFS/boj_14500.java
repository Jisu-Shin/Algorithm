import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int[][]map ;
	static boolean[][]visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		n = Integer.parseInt(s.split(" ")[0]);
		m = Integer.parseInt(s.split(" ")[1]);
		map = new int[n][m]; 
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visited[i][j] = true;
				dfs(i,j,1,0);
				center(i,j);
				visited[i][j] = false;
			}
		}
		System.out.println(answer);
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0}; // 좌우상하
	static int answer;
	public static void dfs(int a, int b,int cnt,int sum) {
		sum+=map[a][b];
		if(cnt==4) {
			answer=Math.max(answer,sum);
			return;
		}
		for(int i=0;i<4;i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(x<0 || y<0 || x>=map.length || y>=map[0].length) continue;
			if(visited[x][y]) continue;
			visited[x][y] = true;
			dfs(x,y,cnt+1,sum);
			visited[x][y] = false;
		}
	}
	
	public static void center(int a, int b) {
		int sum;
		//ㅗ
		if((a>=0&&a<n-1) && (b>=1&&b<m-1)) {
			sum=map[a][b]+map[a+1][b-1]+map[a+1][b]+map[a+1][b+1];
			answer=Math.max(sum,answer);
		}
		//ㅜ
		if((a>=1&&a<n) && (b>=1&&b<m-1)) {
			sum=map[a][b]+map[a-1][b-1]+map[a-1][b]+map[a-1][b+1];
			answer=Math.max(sum,answer);
		}
		//ㅏ
		if((a>=1&&a<n-1) && (b>=1&&b<m)) {
			sum=map[a][b]+map[a-1][b-1]+map[a][b-1]+map[a+1][b-1];
			answer=Math.max(sum,answer);
		}
		//ㅓ
		if((a>=1&&a<n-1) && (b>=0&&b<m-1)) {
			sum=map[a][b]+map[a-1][b+1]+map[a][b+1]+map[a+1][b+1];
			answer=Math.max(sum,answer);
		}
	}
}