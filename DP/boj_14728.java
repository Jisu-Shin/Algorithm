import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[]dp;
	static int n,t;
	static int[]k,s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		dp = new int[t+1];

		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int ki = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			Knapsack(ki,si);
		}
		System.out.println(dp[t]);
	}
	
	public static void Knapsack(int ki, int si) {
		for(int j=t;j>=ki;j--) {
			if(dp[j]<dp[j-ki]+si) {
				dp[j]=dp[j-ki]+si;
			}
		}
	}
}