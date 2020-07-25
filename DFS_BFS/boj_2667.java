import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static char[][]map;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		map = new char[m][m];
		PriorityQueue<Integer> prio = new PriorityQueue<>();
		for(int i=0;i<m;i++) {
			map[i]=br.readLine().toCharArray();
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='1') {
					dfs(i,j);
				}
				if(answer>0) {
					prio.add(answer);
					answer=0;
				}
			}
		}
		System.out.println(prio.size());
		while(!prio.isEmpty()) {
			System.out.println(prio.poll());
		}
		
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int answer;
	public static void dfs(int a, int b) {
		map[a][b]=0;
		answer++;
		for(int i=0;i<4;i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(x<0 || y<0 || x>map.length-1 || y>map.length-1) continue;
			if(map[x][y]=='1') {
				dfs(x,y);
			}
		}
	}
}