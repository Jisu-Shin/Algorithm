import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class edge implements Comparable<edge>{
	int node, cost;
	edge(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	public int compareTo(edge e) {
		return this.cost - e.cost;
	}
}
public class Main {
	static ArrayList<edge>[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int idx = Integer.parseInt(br.readLine());

		//배열로 하면 공간부족
		arr = new ArrayList[n+1];
		int[] answer = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]= new ArrayList<edge>();
            			answer[i]=Integer.MAX_VALUE;
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i].add(new edge(j,cost));
		}

		PriorityQueue<edge> q = new PriorityQueue<>();
		q.add(new edge(idx,0));

		while(!q.isEmpty()) {
			edge e = q.poll();
			int node = e.node;
			int cost = e.cost;
            			if(answer[node]<cost) continue;
			for(int i=0;i<arr[node].size();i++) {
				int nextNode = arr[node].get(i).node;
				int nextCost = arr[node].get(i).cost;
				if(answer[nextNode]>(nextCost+cost)) {
					answer[nextNode] = nextCost+cost;
					q.add(new edge(nextNode,nextCost+cost));
				}
			}
		}

		StringBuilder ans = new StringBuilder();
		for(int i=1;i<=n;i++) {
			if(i==idx) ans.append("0\n");
			else if(answer[i]==Integer.MAX_VALUE) ans.append("INF\n");
			else ans.append(answer[i]+"\n");
		}
		System.out.println(ans);

	}
}