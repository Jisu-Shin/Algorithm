import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long max=0;
		int[] arr = new int[k];

		for(int i=0;i<k;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			max=Math.max(arr[i], max);
		}
		long min=1;
		long mid=0;
		long answer=0;

		while(min<=max) {
			int cnt=0;
			mid=(min+max)/2;
			//bw.write(String.valueOf(min)+" "+String.valueOf(mid)+" "+String.valueOf(max)+"\n");
			//if(mid==0) break;
			for(int j : arr) {
				cnt+=j/mid;
			}
			if(cnt>=n) {
				answer=Math.max(answer, mid);
				min=mid+1;
			}
			else max=mid-1;

		}
		//bw.write(String.valueOf(min)+" "+String.valueOf(mid)+" "+String.valueOf(max)+"\n");
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}