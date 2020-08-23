import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] sosu = new boolean[1000001];
		sosu[0]=true;
		sosu[1]=true;
		for(int i=2;i<sosu.length;i++) {
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					sosu[i] = true;
					break;
				}
			}
		}
		
		int num=1;
		StringBuilder sb = new StringBuilder();
		while(num!=0) {
			num=Integer.parseInt(br.readLine());
			for(int i=num;i>=0;i--) {
				if(!sosu[i] && !sosu[num-i]) {
					sb.append(num+" = "+(num-i)+" + "+i+"\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
