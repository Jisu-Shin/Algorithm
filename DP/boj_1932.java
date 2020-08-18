import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = st.countTokens();
			for(int j=0;j<count;j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					tri[i][j]+=tri[i-1][j];
				}
				else if(j==i) {
					tri[i][j]+=tri[i-1][j-1];
				}
				else {
					tri[i][j]+=Math.max(tri[i-1][j-1],tri[i-1][j]);
				}
			}
		}
		
		int answer=0;
		for(int i=0;i<n;i++) {
			answer = Math.max(answer,tri[tri.length-1][i]);
		}
		System.out.println(answer);
	}
}