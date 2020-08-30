import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=0;
		int len=0;
		int sum=0;
		int answer = n+1;
		while(true) {
			if(sum<s) {
				if(right==n) break;
				sum+=arr[right++];
				len++;
			}
			else {
				answer = Math.min(len,answer);
				sum-=arr[left++];
				len--;
			}
		}
		if(answer==(n+1)) answer=0;
		System.out.println(answer);
	}
}