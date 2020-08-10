import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s.split(" ")[0]);
		int k = Integer.parseInt(s.split(" ")[1]);
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int sum=0;
		int answer=0;
		int idx=n-1;
		while(k!=0) {
			answer=k/arr[idx];
			k=k-answer*arr[idx--];
			sum+=answer;
		}
		System.out.println(sum);
	}
}