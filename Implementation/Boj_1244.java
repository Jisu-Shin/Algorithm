package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244 {

	static char[]switches;

	static void swiTwo(int idx, int chk) {
		
		if((idx-chk)>=1 && (idx+chk)<switches.length && switches[idx+chk]==switches[idx-chk]) {
			switches[idx+chk]=switches[idx+chk]=='0'?'1':'0';
			switches[idx-chk]=switches[idx+chk];
			swiTwo(idx,chk+1);
		}
		else {
			return;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		switches = new char[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			switches[i]=st.nextToken().charAt(0);
		}

		int stu = Integer.parseInt(br.readLine());
		for(int i=0;i<stu;i++) {
			st=new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());

			if(sex==1) {
				for(int j=idx;j<switches.length;j+=idx) {
					switches[j]=switches[j]=='0'?'1':'0';
					//System.out.print(idx+" "+switches[idx]+" ");
				}
				//System.out.println(Arrays.toString(switches));
				
			}
			else {
				swiTwo(idx,1);
				switches[idx]=switches[idx]=='0'?'1':'0';
				//System.out.println(Arrays.toString(switches));

			}

		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<switches.length;i++) {
			sb.append(switches[i]+" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb);
	}

}
