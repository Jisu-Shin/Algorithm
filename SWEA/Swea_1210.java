package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5
public class Swea_1210 {

	static StringBuffer sb = new StringBuffer();
	//좌, 우 , 하
	static int[][]dirs = {{0,-1},{0,1},{1,0}};
	static char[][]ladder = new char[100][100];
	static boolean[][]visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			
			int T = Integer.parseInt(br.readLine());
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					ladder[i][j]=st.nextToken().charAt(0);
				}
			}
			
			int answer=0;
			
			for(int i=0;i<100;i++) {
				if(ladder[0][i]=='1') {
					visited=new boolean[100][100];
					if(searchPath(0,i)) {
						answer=i;
						break;
					}
				}
			}		
			
			sb.append("#"+tc+" "+answer+"\n");
			
		}
		System.out.println(sb);
	}
	
	static public boolean searchPath(int x, int y) {
		//System.out.println(x+" "+y);
		visited[x][y]=true;
		if(ladder[x][y]=='2') {
			return true;
		}
		for(int i=0;i<dirs.length;i++) {
			int dx = x + dirs[i][0];
			int dy = y + dirs[i][1];
			if(dx<0 || dx>=100 || dy<0 || dy >=100) continue;
			if(ladder[dx][dy]=='0' || visited[dx][dy] ) continue;
			//재귀니까 return을 적어줘야함 안하면 값을 찾았는데도 아래의 false로 들어감
			return searchPath(dx,dy);
		}
		return false;
	}

}
