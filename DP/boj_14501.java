package backjun;

import java.io.*;
public class Main2 { 
	public static void main(String[] args) throws IOException { 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[21]; // 최대 일수 15+5 
		int day,profit;

		for(int i=0;i<num;i++) {
			String s = br.readLine();
			day=Integer.parseInt(s.split(" ")[0]);
			profit=Integer.parseInt(s.split(" ")[1]);

			dp[i+1]=Math.max(dp[i+1], dp[i]); // 이익을 누적시키기 위해
			dp[i+day]=Math.max(dp[i+day],dp[i]+profit); // i일의 일을 했을 경우 
		}

		System.out.println(dp[num]);
	}
}

