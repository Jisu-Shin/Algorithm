import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class dot {
	int x, y;
	dot (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][]box;
	static ArrayDeque<dot> q = new ArrayDeque<>();
	static int[] xi = {0,0,-1,1};
	static int[] yi = {-1,1,0,0};
	static int answer;

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		int chkbox=0; // 다 돌았는지 확인하기 위한
		
		for(int i=0;i<box.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<box[0].length;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1 ) { // que에 넣어준다
					new dot(1,3);
					q.add(new dot(i,j));
				}
				else if(box[i][j]==-1) chkbox++; // -1은 bfs로 감지 못하므로 따로 합산해준다
			}
		}
		int answer=0;
		while(!q.isEmpty()) { 
			int size=q.size(); // q에 들어간 값만큼이 하루이기 때문
			while(size-->0) {
				int x = q.peek().x;
				int y = q.poll().y;
				bfs(x,y);
				chkbox++;
			}
			answer++;
		}
		if(n*m==chkbox) System.out.println(answer-1); // 토마토가 익은 것부터 하루로 셌기 때문에 -1해준다
		else System.out.println(-1); // 전체가 익지 않았을 경우
	}

	public static void bfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int a = x+xi[i];
			int b = y+yi[i];

			if(a<0 || b<0) continue;
			if(a>=box.length || b>=box[0].length) continue;

			if(box[a][b]==0) {
				q.add(new dot(a,b));
				box[a][b]=1;
			}
		}
	}
}
