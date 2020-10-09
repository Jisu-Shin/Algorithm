package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[]arr =new int[n];
		int[]dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
	
		int answer=dp[0]=1;
		for(int i=1;i<n;i++) {
			int len=0;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) len = Math.max(len,dp[j]);
			}
			dp[i]=len+1;
			answer = Math.max(answer,dp[i]);
		}
		System.out.println(answer);
	}
}