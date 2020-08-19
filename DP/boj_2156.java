import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] wine = new int[n];
		for(int i=0;i<n;i++) {
			wine[i]=Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n];
		dp[0]=wine[0];
		for(int i=1;i<n;i++) {
			if(i==1) dp[i]=wine[i]+wine[i-1];
			else if(i==2) dp[i]=wine[i]+Math.max(wine[i-1],wine[i-2]);
			else if(i>=3) {
				for(int j=i;j<n;j++) {
					dp[i]=wine[i]+Math.max(dp[i-2],wine[i-1]+dp[i-3]);
					dp[i]=Math.max(dp[i-1],dp[i]);
				}
			}
			dp[i]=Math.max(dp[i-1],dp[i]);
		}
		System.out.println(dp[n-1]);
	}
}

