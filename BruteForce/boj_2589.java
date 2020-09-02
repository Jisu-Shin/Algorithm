import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Dot{
	int x,y,cnt;
	Dot(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int n,m;
	static char[][] arr;
	static boolean[][] visited;
	static int answer=0;
	static ArrayDeque<Dot> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr= new char[n][m];
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='L') {
					visited=new boolean[n][m];
					q.add(new Dot(i,j,0));
					while(!q.isEmpty()) {
						bfs(q.poll());
					}
				}
			}
		}
		System.out.println(answer);
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void bfs(Dot d) {
		int x = d.x;
		int y = d.y;
		int cnt = d.cnt;
		visited[x][y]=true;
		answer = Math.max(cnt,answer);
		for(int i=0;i<4;i++) {
			int xi = dx[i]+x;
			int yi = dy[i]+y;
			if(xi<0 || yi<0 || xi>=n || yi>=m) continue;
			if(arr[xi][yi]=='L' && !visited[xi][yi]) {
                visited[xi][yi]=true;
				q.add(new Dot(xi,yi,cnt+1));
			}
		}
	}
}