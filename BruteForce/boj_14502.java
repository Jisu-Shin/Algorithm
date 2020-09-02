import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Dot{
	int x,y;
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static ArrayList<Dot> possible = new ArrayList<>();
	static ArrayList<Dot> virus = new ArrayList<>();
	static boolean[] visited;
	static int [][] map;
	static int [][] tmp;
	static int n,m;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) possible.add(new Dot(i,j));
				else if(map[i][j]==2) virus.add(new Dot(i,j));
			}
		}
		visited = new boolean[possible.size()];
		dfs(0,0);
		System.out.println(answer);
	}

	public static void deepCopy() {
		tmp = new int[n][m];
		for(int i=0;i<map.length;i++) {
			tmp[i]=map[i].clone();
		}
	}

	public static void dfs(int cnt,int idx) {
		if(cnt==3) {
            deepCopy();
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					Dot p = possible.get(i);
					tmp[p.x][p.y]=1;
				}
			}
			find();
			return;
		}
		else if(idx<visited.length) {
			visited[idx]=true;
			dfs(cnt+1,idx+1);
			visited[idx]=false;
			dfs(cnt,idx+1);
		}
		return;
	}


	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int answer=0;
	private static void find() {
		for(int i=0;i<virus.size();i++) {
			int x = virus.get(i).x;
			int y = virus.get(i).y;
			spread(x,y);
		}
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tmp[i][j]==0) cnt++;
			}
		}
		answer = Math.max(answer,cnt);
	}

	public static void spread(int x, int y) {
		for(int j=0;j<4;j++) {
			int xi = dx[j]+x;
			int yi = dy[j]+y;
			if(xi<0||yi<0||xi>=n||yi>=m) continue;
			if(tmp[xi][yi]==0) {
				tmp[xi][yi]=2;
				spread(xi,yi);
			}
		}
	}
}