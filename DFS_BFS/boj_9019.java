import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class pair{
	int x;
	String s;
	pair(int x , String s){
		this.x = x;
		this.s = s;
	}
}
public class Main {
	static int a,b;
	static boolean[] visited;
	static ArrayDeque<pair> q;

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a  =Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			q = new ArrayDeque<>();
			q.add(new pair(a,""));
            visited[a]=true;
			bw.write(bfs()+"\n");
		}
		bw.flush();
		bw.close();

	}
	public static String bfs() {
		String answer="";
		while(!q.isEmpty()) {
			int num = q.peek().x;
			String s = q.poll().s;
			if(num==b) {
				answer=s;
				break;
			}
			int D = (num*2)%10000;
			int S = num-1<0?9999:num-1;
			int L = (num%1000)*10+(num/1000);
			int R = (num%10)*1000+(num/10);

			if(!visited[D]) {
				visited[D]=true;
				q.add(new pair(D,s+"D"));
			}
			if(!visited[S]) {
				visited[S]=true;
				q.add(new pair(S,s+"S"));
			}
			if(!visited[L]) {
				visited[L]=true;
				q.add(new pair(L,s+"L"));

			}
			if(!visited[R]) {
				visited[R]=true;
				q.add(new pair(R,s+"R"));

			}
		}
		return answer;
	}
}