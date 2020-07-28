import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][]map;
	static int[][]answer;
	static boolean[]visited;

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		answer = new int[n][n];
		for(int i=0;i<n;i++) {
			String s = br.readLine().replaceAll(" ", "");
			map[i]=s.toCharArray();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]=='1') {
					visited = new boolean[n];
					visited[j] = true;
					dfs(j);
					for(int k=0;k<visited.length;k++) {
						if(visited[k]) answer[i][k]=1; 
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int j) {
		for(int k=0;k<answer.length;k++) {
			if(map[j][k]=='1'&&!visited[k]) {
				visited[k]=true;
				dfs(k);
			}
		}
	}
}