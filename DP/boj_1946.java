import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[]arr = new int[n+1];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx=Integer.parseInt(st.nextToken());
				arr[idx]=Integer.parseInt(st.nextToken());
			}

			int answer=1;
			int min=arr[1];
			for(int i=1;i<=n;i++) {
				if(min>arr[i]) {
					min=arr[i];
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}