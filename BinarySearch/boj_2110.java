import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long max = arr[n-1];
		long min = 1;
		long mid=0;
		long answer=0;
		while(min<=max) {
			int cnt=1;
			int idx=0;
			mid = (max+min)/2;
			long dist=0;
			for(int i=idx+1;i<n;i++) {
				dist=arr[i]-arr[idx];
				if(dist>=mid) {
					idx=i;
					cnt++;
				}
			}
			if(cnt<c) max=mid-1;
			else {
				answer=Math.max(answer,mid);
				min=mid+1;
			}
		}
		System.out.println(answer);
	}
}