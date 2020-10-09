package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] visited = new int[100001];
		ArrayDeque<Integer> q = new ArrayDeque();
		q.add(n);

		int answer=0;
		int cnt=0;
		while(cnt==0) {
			int s = q.size();
			// 큐의 모든 값을 빼낸다 -> 동일한 cnt
			while(s-->0) { 
				int x = q.poll();
				if(x==k) cnt++;
				int[] jump = {x-1,x+1,x*2};
				for(int ni:jump) {
					// 이동 범위
					if(ni<0 ||ni>100000) continue;
					// 0이 아니고 이동할 값이랑 이전 값이 같지 않을 경우 추가
					if(visited[ni]!=0 && visited[ni]!=visited[x]+1) continue;
					q.add(ni);
					visited[ni]=visited[x]+1;
				}
			}
			
			// cnt가 0일 경우(=동일한 값이 아닐 경우) 계속 상승
			answer++;

		}
		System.out.println((answer-1)+"\n"+cnt);
	}

}