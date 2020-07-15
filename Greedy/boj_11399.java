package backjun;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> prio = new PriorityQueue<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			prio.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum=0;
		int answer=0;
		while(!prio.isEmpty()) {
			sum+=prio.poll();
			answer+=sum;
		}
		System.out.println(answer);
	}
}

