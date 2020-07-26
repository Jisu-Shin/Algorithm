import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class dot {
	int x;
	int y;
	dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static ArrayList<dot> house = new ArrayList<>();
	static ArrayList<dot> chicken = new ArrayList<>();
	static boolean[] visited;
	static int n, m;
	static int ans;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				dot d = new dot(i,j);
				if(num==1) {
					house.add(d);
				}
				else if(num==2) {
					chicken.add(d);
				}
			}
		}
		visited = new boolean[chicken.size()];
		ans = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(ans);
	}

	public static void dfs(int cur_num, int cur_cnt) {
		if(cur_cnt==m) {	
			int cmp = 0;
			for(int i=0;i<house.size();i++) {
				int dist = Integer.MAX_VALUE;
				int px = house.get(i).x;
				int py = house.get(i).y;
				for(int j=0;j<chicken.size();j++) {
					if(visited[j]) {
						int d = Math.abs(chicken.get(j).x - px)+Math.abs(chicken.get(j).y - py);
						dist = Math.min(dist,d);
					}
				}
				cmp += dist;
			}
			ans = Math.min (ans,cmp);
			return;
		}
		if(cur_num == visited.length) return;
		visited[cur_num] = true;
		dfs(cur_num+1,cur_cnt+1);
		visited[cur_num] = false;
		dfs(cur_num+1,cur_cnt);
	}
}