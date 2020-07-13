package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num = new int[10];

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int channel = Integer.parseInt(br.readLine());
		int broken = Integer.parseInt(br.readLine());
		int ans = Math.abs(channel-100);
		
		if(broken==0) {
			System.out.println(Math.min(ans,String.valueOf(channel).length()));
			return;
		}
		else {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int i=0;i<broken;i++) {
				num[Integer.parseInt(st.nextToken())]=1; // 고장난번호
			}
		}

		for(int i=0;i<=1000000;i++) {
			if(check(i)) {
				int tmp = Math.abs(i-channel)+(String.valueOf(i)).length();
				ans=Math.min(ans,tmp);
			}
		}
		System.out.println(ans);
	}

	public static boolean check(int x) {
		while(x!=0) {
			if(num[x%10]==1) {
				return false;
			}
			x/=10;
		}
		return true;
	}
}


