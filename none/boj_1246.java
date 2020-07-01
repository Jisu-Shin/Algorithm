import java.io.*;
import java.util.*;

public class boj_1246 {

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s=br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int egg = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			int[] p = new int[customer];
			for(int i=0;i<p.length;i++) {
				p[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(p);
			int maxValue=0;
			int price=0;
			for(int i=1;i<=Math.min(egg,customer);i++) {
				if(maxValue<p[p.length-i]*i){
					maxValue=p[p.length-i]*i;
					price=p[p.length-i];
				}
			}
			System.out.println(price+" "+maxValue);	
	}

}
