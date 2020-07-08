package backjun;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());

		long[] dp = new long[cnt+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<cnt+1;i++) {
			int j; 
			for(j=i-1;j>-1;j--) {
				dp[i]+= dp[j]*dp[i-j-1];
			}
		}
		System.out.println(dp[cnt]);
	}
}


