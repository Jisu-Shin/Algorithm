import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());
		
		long[] dp = new long [cnt+1];
		
		dp[0]=1;
		dp[1]=2;
		for(int i=2;i<dp.length;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10;
			}
		
		System.out.println(dp[cnt-1]);
		
	}
}