package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Bus implements Comparable<Bus>{
	int node,cost;
	Bus(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Bus arg0) {
		
		return this.cost - arg0.cost;
	}
}
public class Main {
	static ArrayList<Bus>[] arr ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		arr = new ArrayList[n+1]; // 버스 정보 저장
		int[] answer = new int[n+1]; // 출발도시에서 각 도착도시까지의 비용저장
		for(int i=1;i<n+1;i++) {
			arr[i]=new ArrayList<Bus>();
			answer[i] = Integer.MAX_VALUE;
		}
		
		// 버스의 정보 , 메모리초과 방지
		StringTokenizer st;
		int x,y;
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[x].add(new Bus(y,cost));
		}
		
		//출발도시, 도착도시
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Bus> que = new PriorityQueue();
		que.add(new Bus(x,0));
		while(!que.isEmpty()) {
			Bus b = que.poll();
			int node = b.node;
			int cost = b.cost;
			
			//반복문 돌릴 필요가 없음
			if(answer[node]<cost) continue;
			
			for(int i=0;i<arr[b.node].size();i++) {
				int nextNode = arr[b.node].get(i).node;
				int nextCost = arr[b.node].get(i).cost;
				//최소비용(누적)일 경우에만 큐에 삽입
				if(answer[nextNode]>(cost+nextCost)) {
					answer[nextNode] = cost+nextCost;
					que.add(new Bus(nextNode,cost+nextCost));
				}
			}
		}
		
		System.out.println(answer[y]);
		
		
	}
}