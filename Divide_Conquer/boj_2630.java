import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][]arr ;
	static int[] paper = new int[2];
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0,n);
		System.out.println(paper[0]+"\n"+paper[1]);
	}

	public static void divide(int x, int y, int m) {
		if(m==1) {
			paper[arr[x][y]]++;
		}
		else {
			boolean chk = true;
			int first = arr[x][y];
			for(int i=x;i<x+m;i++) {
				for(int j=y;j<y+m;j++) {
					if(first!=arr[i][j]) {
						chk=false;
						break;
					}
				}
				if(!chk) break;
			}
			int mi = m/2;
			if(chk) paper[first]++;
			else {
				divide(x,y,mi);
				divide(x,y+mi,mi);
				divide(x+mi,y,mi);
				divide(x+mi,y+mi,mi);
			}

		}

	}
}