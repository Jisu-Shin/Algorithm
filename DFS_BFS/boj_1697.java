import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

class Find{
	int n,cnt;
	Find(int n, int cnt){
		this.n = n;
		this.cnt = cnt;
	}
}

public class Main {

	static ArrayDeque<Find> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];

		q.add(new Find(n,0));
		visited[n]=true;

		while(!q.isEmpty()) {
			int ni = q.peek().n;
			int cnt = q.pop().cnt;
			
			if(ni==k) {
				System.out.println(cnt);
				break;
			}
			
			if(ni>=1 && ni<100001 && !visited[ni-1]) {
				visited[ni-1]=true;
				q.add(new Find(ni-1,cnt+1));
			}
			if(ni>=0 && ni<100000 &&!visited[ni+1]) {
				visited[ni+1]=true;
				q.add(new Find(ni+1,cnt+1));
			}
			if(ni>=0 && ni<50001 &&!visited[ni*2]) {
				visited[ni*2]=true;
				q.add(new Find(ni*2,cnt+1));
			}
		}
	}

}