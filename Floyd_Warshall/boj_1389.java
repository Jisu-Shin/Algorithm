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
		int[][] map = new int[n+1][n+1];

		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y]=map[y][x]=1;
		}


		for(int k=1;k<map.length;k++) {
			for(int i=1;i<map.length;i++) {
				for(int j=1;j<map.length;j++) {
					if(i==j) continue;
					else if(map[i][k]!=0&&map[k][j]!=0) {	
						if(map[i][j]==0) {
							map[i][j]=map[i][k]+map[k][j];
						}
						else {
							map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
						}
					}
				}

			}
		}

		int answer=Integer.MAX_VALUE;
		int idx=Integer.MAX_VALUE;
		for(int i=1;i<map.length;i++) {
			int sum=0;
			for(int j=1;j<map.length;j++) {
				sum+=map[i][j];
			}
			if(answer>sum) {
				answer=sum;
				idx=i;
			}
		}
		System.out.println(idx);
	}

}
