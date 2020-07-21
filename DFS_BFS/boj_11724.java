import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[][] map;
	static int[] visited;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new int[n+1];
		map = new int[n+1][n+1];

		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y]=1;
			map[y][x]=1;
		}

		int answer=0;
		for(int i=1;i<n+1;i++) {
			if(visited[i]==0) {
				answer++;
				dfs(i);
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int i) {
		visited[i]=1;
		for(int k=1;k<map.length;k++) {
			if(visited[k]==0&&map[i][k]==1) {
				dfs(k);
			}
		}
	}
}