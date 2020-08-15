import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class dot{
	int x,y;
	dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			n+=2;
			dot[] arr = new dot[n];
			boolean[] visited = new boolean[n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = new dot(x,y);
			}

			ArrayDeque<dot> q = new ArrayDeque();
			q.add(arr[0]);
			visited[0]=true;
			
			while(!q.isEmpty()) {
				int xi = q.peek().x;
				int yi = q.pop().y;
				if(visited[n-1]) {
					break;
				}
				for(int i=1;i<arr.length;i++) {
					if(visited[i]) continue;
					
					int dist = Math.abs(arr[i].x-xi)+Math.abs(arr[i].y-yi);
					if(dist<=1000) {
						visited[i]=true;
						q.add(arr[i]);
					}
				}
			}
			
			if(visited[n-1]) System.out.println("happy");
			else System.out.println("sad");
		}

	}
}