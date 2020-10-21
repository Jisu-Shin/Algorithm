package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[]dp;
	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int wi = Integer.parseInt(st.nextToken());
			int vi = Integer.parseInt(st.nextToken());
			Knapsack(wi,vi);
		}
		System.out.println(dp[k]);
		
	}
	
	public static void Knapsack(int wi, int vi) {
		for(int i=k;i>=wi;i--) {
			if(dp[i]<vi+dp[i-wi]) {
				dp[i]=vi+dp[i-wi];
			}
		}
	}
}