import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;


class Dot{
	int x,y,cnt;
	Dot(int x,int y,int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static char[][]map;
	static ArrayDeque<Dot> q = new ArrayDeque<>();
	static int[]dx = {0,0,-1,1};
	static int[]dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map =new char[n][m];
		for(int i=0;i<n;i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		q.add(new Dot(0,0,1));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int cnt = q.pop().cnt;
			
			if(x==n-1 && y==m-1) {
				System.out.println(cnt);
				break;
			}
			
			for(int i=0;i<4;i++) {
				int xi = x+dx[i];
				int yi = y+dy[i];
				if(xi<0 || yi<0 || xi>=n ||yi>=m) continue;
				if(map[xi][yi]=='1') {
					map[xi][yi]='0';
					q.add(new Dot(xi,yi,cnt+1));
				}
			}

		}
	}
}


