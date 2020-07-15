import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[][] arr ;
	static int answer;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[com+1];
		arr = new int[com+1][com+1];
				
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 =Integer.parseInt(st.nextToken());
			int com2 =Integer.parseInt(st.nextToken());
			arr[com1][com2]=1;
			arr[com2][com1]=1;
		}
		
		answer=0;
		dfs(1);
		System.out.println(answer);

	
	}
	public static void dfs(int n) {
		visited[n]=true;
		for(int i=1;i<visited.length;i++) {
			if(!visited[i]&&arr[n][i]==1) {
				answer++;
				dfs(i);
			}
		}
	}
}