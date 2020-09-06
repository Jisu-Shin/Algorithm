import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		arr =new int[n];
		int nega=0;
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]<0) nega++;
		}
		Arrays.sort(arr);
		System.out.println(asc(nega));
	}
	public static int asc(int nega) {
		int sum=0;
		int ne = nega;
		if(nega>0) {
			if(nega%2==0) {
				for(int i=0;i<nega;i+=2) {
					sum+=arr[i]*arr[i+1];
				}
			}
			else {
				for(int i=0;i<nega-1;i+=2) {
					sum+=arr[i]*arr[i+1];
				}
				if(nega<n&&arr[nega]==0&&arr[nega-1]<0) {
					nega++;
				}
				else nega--;
			}
		}
		for(int i=n-1;i>=nega;i--) {
			if(i>nega) {
				int tmp = arr[i]*arr[i-1];
				int max = Math.max(tmp,arr[i]+arr[i-1]);
				if(max==tmp) sum+=tmp;
				else sum+=arr[i]+arr[i-1];
				i--;
			}
			else{
				sum+=arr[i];
			}
		}
		return sum;
	}
}
