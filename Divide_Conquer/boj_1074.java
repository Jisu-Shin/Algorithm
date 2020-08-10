import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long cnt=-1;
	static int r,c;
	static long[][]map;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		n =(int) Math.pow(2,n);
		divide(0,0,n,0);
		}

	public static void divide(int x, int y, int n,int start) {
		if (r-x<0 || c-y<0|| r-x>=n || c-y>=n) return;
		int m=n/2;
		if(n==1) {
			System.out.println(start);
		}
		else {
			divide(x,y,m,start); //0
			divide(x,y+m,m,start+(int)Math.pow(n,2)/4);//16
			divide(x+m,y,m,start+(int)Math.pow(n,2)/2);//32
			divide(x+m,y+m,m,start+(int)Math.pow(n,2)/4*3);//48			
		}
	}
}