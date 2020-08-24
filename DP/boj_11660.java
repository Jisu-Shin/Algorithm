import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][]map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				if(j==1) map[i][j]= Integer.parseInt(st.nextToken());
				else map[i][j]= map[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int answer =0;
			for(int j=x1;j<=x2;j++) {
				answer+=map[j][y2]-map[j][y1-1];
			}
			sb.append(answer+"\n");
		}

		System.out.println(sb);
	}
}