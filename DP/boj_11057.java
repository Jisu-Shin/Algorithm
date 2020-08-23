import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][]dp = new int[n+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				int sum=0;
				for(int k=j;k<10;k++) {
					sum+=dp[i-1][k]%10007;
				}
				dp[i][j]=sum;
			}
		}
		
		int answer=0;
		for(int i=0;i<10;i++) {
			answer+=dp[n][i];
		}
		System.out.println(answer%10007);
	}
}