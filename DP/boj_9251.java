import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c1 = String.valueOf("0"+br.readLine()).toCharArray();
		char[] c2 = String.valueOf("0"+br.readLine()).toCharArray();
		int[][] dp= new int[c2.length+1][c1.length];
		int answer=0;
		for(int i=1;i<c2.length;i++) {
			for(int j=1;j<c1.length;j++) {
				if(c2[i]==c1[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				answer = Math.max(answer,dp[i][j]);
			}
		}
		System.out.println(answer);
		
	}
}