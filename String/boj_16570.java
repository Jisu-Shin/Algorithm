import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] pi;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr =new int[n];
		for(int i=n-1;i>=0;i--) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int len=0;
		int cnt=0;
		int[]pi = getPi(arr);
		for(int p : pi) {
			if(p>len) {
				len=p;
				cnt=1;
			}
			else if(p==len) cnt++;
		}
		if(len==0) System.out.println("-1");
		else System.out.println(len+" "+cnt);
	}


	public static int[] getPi(int[] p) {
		int[]pi = new int[p.length];
		int j=0;
		for(int i=1;i<p.length;i++) {
			while(j>0 && p[j]!=p[i]){
				j=pi[j-1];
			}
			if(p[j]==p[i]) {
				pi[i]=++j;
			}
		}
		return pi;
	}
}