package backjun;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());
		
		int[][] dp = new int[41][2];
		dp[0][0]=1; dp[1][1]=1;
		for(int i=2;i<dp.length;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-2][0];
			dp[i][1]=dp[i-1][1]+dp[i-2][1];
		}
		
		String answer="";
		
		for(int i=0;i<cnt;i++) {
			String s = br.readLine();
			int n = Integer.parseInt(s);
			answer+=dp[n][0]+" "+dp[n][1]+"\n";
		}
		
		System.out.println(answer);	
	}
}


