import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
	static boolean[] visited,visited2;
	static int[][] map;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int visit = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		visited = new boolean[visit+1];
		visited2 = new boolean[visit+1];
		map = new int[visit+1][visit+1];
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y]=1;
			map[y][x]=1;
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(dfs(start,sb));
		sb = new StringBuilder();
		ArrayDeque<Integer> que = new ArrayDeque<>();
		System.out.println(bfs(start,sb,que));
		
	}
	public static String dfs(int start,StringBuilder sb) {
		visited[start] = true;
		sb.append(start).append(" ");
		for(int i=1;i<map.length;i++) {
			if(!visited[i]&&map[start][i]==1) {
				dfs(i,sb);
			}
		}
		return sb.toString();
	}
	public static String bfs(int start,StringBuilder sb,ArrayDeque<Integer> que) {
		sb.append(start).append(" ");
		for(int i=1;i<map.length;i++) {
			if(!visited2[i]&&map[start][i]==1) {
				que.add(i);
				visited2[i]=true;
			}
		}
		visited2[start] = true;
		while(!que.isEmpty()) {
			bfs(que.remove(),sb,que);
		}
		
		return sb.toString();
	}

}