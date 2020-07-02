package backjun;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());
		
		int[][] dp = new int[31][31];
		for(int j=1;j<dp[0].length;j++) dp[1][j]=j;
		for(int j=2;j<dp.length;j++) {
			for(int k=2;k<dp[0].length;k++) {
				dp[j][k]=dp[j-1][k-1]+dp[j][k-1];
			}
		}
		
		String answer="";
		
		for(int i=0;i<cnt;i++) {
			String s = br.readLine();
			int n = Integer.parseInt(s.split(" ")[0]);
			int m = Integer.parseInt(s.split(" ")[1]);
			answer+=dp[n][m]+"\n";
		}
		
		System.out.println(answer);
			
	}
}


