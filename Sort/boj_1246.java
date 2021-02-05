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
				p[i]=Integer.parseInt(br.readLine()); //달걀 가격 pi를 받는다
			}
			Arrays.sort(p);
			int maxValue=0;
			int price=0; 
			
			//egg가 작을 수도 있어서 범위는 Math.min 
			for(int i=1;i<=Math.min(egg,customer);i++) { // 가장 높은 가격부터 * i(=1,2,3,...)
				if(maxValue<p[p.length-i]*i){ // 값이 커질 때 변수 값 변경
					maxValue=p[p.length-i]*i; // 오름차순으로 했기 때문에 length-i 이다
					price=p[p.length-i];
				}
			}
			System.out.println(price+" "+maxValue);	
	}

}
