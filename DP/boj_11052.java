import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[n+1];
		for(int i=1;i<=n;i++) {
			cards[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		dp[1]=cards[1];
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i/2;j++) {
				dp[i]=Math.max(dp[i],Math.max(dp[i-j]+dp[j],cards[i]));
			}
		}
		System.out.println(dp[n]);
	}
}

