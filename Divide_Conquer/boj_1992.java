import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Dot{
	int x,y,m;
	Dot(int x, int y,int m){
		this.x = x;
		this.y = y;
		this.m = m;
	}
}

public class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		map = new char[m][m];
		for(int i=0;i<m;i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		String answer = divide(new Dot(0,0,m));
		System.out.println(answer);
	}
	public static String divide(Dot d) {
		int n = d.m/2;
		if(d.m==1) {
			String s = String.valueOf(map[d.x][d.y]);
			return s;
		}
		else {
			String sarr="(";
			sarr+=divide(new Dot(d.x,d.y,n));
			sarr+=divide(new Dot(d.x,d.y+n,n));
			sarr+=divide(new Dot(d.x+n,d.y,n));
			sarr+=divide(new Dot(d.x+n,d.y+n,n));
			sarr+=")";
			if(sarr.equals("(1111)")) {
				sarr="1";
			}
			else if(sarr.equals("(0000)")) {
				sarr="0";
			}
			return String.valueOf(sarr);
		}
	}
}
