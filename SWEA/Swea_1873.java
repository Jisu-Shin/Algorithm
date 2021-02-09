package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Swea_1873 {

	static StringBuilder sb = new StringBuilder();
	static char[][]map;
	static char[]s;
	static int x,y; //전차위치
	//상하좌우
	static char[]forward = {'^','v','<','>'};
	static HashMap<Character, Integer> converse  = new HashMap<Character, Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		converse.put('U', 0);
		converse.put('D', 1);
		converse.put('L', 2);
		converse.put('R', 3);
		converse.put('S', 4);


		int T = Integer.parseInt(br.readLine());
		for(int tc =1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for(int i=0;i<H;i++) {
				map[i]=br.readLine().toCharArray();
				for(int j=0;j<W;j++) {

					//전차위치 파악
					for(int d=0;d<4;d++) {
						if(forward[d]==map[i][j]) {
							x = i;
							y = j;
						}
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			s = br.readLine().toCharArray();

			game2();


			sb.append("#"+tc+" ");
			for(int i=0;i<map.length;i++) {
				sb.append(String.valueOf(map[i])+"\n");
			}

		}
		System.out.println(sb);


	}


	public static void game() {
		for(int i=0;i<s.length;i++) {
			//			print();
			//			System.out.println(s[i]);
			int dx=x,dy=y;
			switch (s[i]) {
			case 'U':
				dx--;
				//				System.out.println(dx+" "+dy);
				if(dx>=0 && dx <map.length && map[dx][dy]=='.') {
					map[dx][dy]='^';
					map[x][y]='.';
					x=dx;
					y=dy;
				}else {					
					map[x][y]='^';
				}
				break;

			case 'D':
				dx++;
				if(dx>=0 && dx <map.length && map[dx][dy]=='.') {
					map[dx][dy]='v';
					map[x][y]='.';
					x=dx;
					y=dy;
				}else {					
					map[x][y]='v';
				}
				break;

			case 'L':
				dy--;
				if(dy>=0 && dy <map[0].length && map[dx][dy]=='.') {
					map[dx][dy]='<';
					map[x][y]='.';
					x=dx;
					y=dy;
				}else {					
					map[x][y]='<';
				}
				break;

			case 'R':
				dy++;
				if(dy>=0 && dy <map[0].length && map[dx][dy]=='.') {
					map[dx][dy]='>';
					map[x][y]='.';
					x=dx;
					y=dy;
				}else {					
					map[x][y]='>';
				}
				break;

			case 'S':
				switch (map[x][y]) {
				//상하좌우 -> 1234
				case '^':
					bomb(1,x,y);
					break;

				case 'v':
					bomb(2,x,y);
					break;

				case '<':
					bomb(3,x,y);
					break;

				case '>':
					bomb(4,x,y);
					break;

				}
			}
		}
	}

	//상하좌우
	static int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void game2() {

		for(int i=0;i<s.length;i++) {
			int idx = converse.get(s[i]);
			
			// U D L R 인경우
			if(idx<4) {
				int dx = x + dir[idx][0];
				int dy = y + dir[idx][1];
				if(dx>=0 && dx <map.length && dy>=0 && dy <map[0].length && map[dx][dy]=='.') {
					map[dx][dy]=forward[idx];
					map[x][y]='.';
					x=dx;
					y=dy;
				}else {					
					map[x][y]=forward[idx]; // 기호만 변경
				}
			}
			
			// S 인경우
			else {				
				for(int k=0;k<4;k++) {
					if(forward[k]==map[x][y]) {
						
						//k 는 상하좌우인지 파악
						bomb(k,x,y);
						break;
					}
				}
			}
		}
	}

	public static void bomb(int d,int x, int y) {
		int dx = x + dir[d][0];
		int dy = y + dir[d][1];

		if(dx<0 || dx>=map.length||dy<0 || dy>=map[0].length) return;
		if(map[dx][dy]=='*') {
			map[dx][dy]='.';
			return;
		}
		else if(map[dx][dy]=='#') {
			return;
		}
		else {
			bomb(d,dx,dy);
		}

	}
}
