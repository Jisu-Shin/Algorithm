package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int[][]map;
	static int[] answer=new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken())+1;
			}
		}

		divide(0,0,n);
		for(int i=0;i<3;i++) {
			System.out.println(answer[i]);
		}
		
	}


	public static void divide(int x, int y, int n) {
		int ni = n/3; //3

		int first = map[x][y];
		boolean chk = true;
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(map[i][j]!=first) {
					chk= false;
					break;
				}
			}
			if(!chk) break;
		}
		
		if(chk) {
			answer[first]++;
		}
		else {
			for(int j=0;j<3;j++) {
				for(int i=0;i<3;i++) {
					divide(x+(ni*j),y+(ni*i),ni);
				}
			}
		}
	}
}

