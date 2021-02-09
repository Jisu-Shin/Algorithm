package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_2805 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int sum=0;
			int n = Integer.parseInt(br.readLine());
			int center = n/2;
			for(int i=0;i<n;i++) {
				char[] tmparr = br.readLine().toCharArray();
				for(int j=0;j<n;j++) {
					int diff = Math.abs(center-i)+Math.abs(center-j);
//					System.out.println(i+" "+j+" "+diff);
					if(diff<center+1) {
//						System.out.println(tmparr[j]);
						sum+=tmparr[j]-'0';
					}
				}
			}
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb);
	}

}
