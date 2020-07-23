package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		char[][] map = new char[m][m];
		char[][] rbMap = new char[m][m];
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			map[i]=s.toCharArray();
			rbMap[i]=s.replaceAll("G", "R").toCharArray();
		}

		System.out.println(dfs(map)+" "+dfs(rbMap));
	}
	public static int dfs(char[][] m) {
		int answer=0;
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				if(m[i][j]=='x') continue;
				char c=m[i][j];
				RGB(i,j,c,m);
				answer++;
			}
		}
		return answer;
	}

	static int[] xi = {-1,1,0,0};
	static int[] yi = {0,0,-1,1};
	public static void RGB(int a,int b,char c,char[][]map) {
		map[a][b]='x';
		for(int i=0;i<4;i++) {
			int x = a+xi[i];
			int y = b+yi[i];

			if(x<0 || y<0) continue;
			if(x>=map.length || y>=map.length) continue;

			if(map[x][y]==c) {
				RGB(x,y,c,map);
			}

		}
	}
}



