package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1954 {

	static StringBuffer sb = new StringBuffer();
	static int[][]arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			makearr();
			
			
			sb.append("#"+tc+"\n");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
	}
	private static void makearr() {
		int cnt=1;
		int l=0,r=arr.length-1,t=0,d=arr.length-1;
		while(cnt<=(arr.length*arr.length)) {
			
			//오른쪽
			for(int i=l;i<=r;i++) {
				arr[t][i]=cnt++;
			}
			t++;
			
			//아래
			for(int i=t;i<=d;i++) {
				arr[i][r]=cnt++;
			}
			r--;
			
			//왼쪽
			for(int i=r;i>=l;i--) {
				arr[d][i]=cnt++;
			}
			d--;
			
			//위
			for(int i=d;i>=t;i--) {
				arr[i][l]=cnt++;
			}
			l++;
//			System.out.println(l+" "+r+" "+t+" "+d);
		}
		
	}

}
