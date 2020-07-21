import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = s.length();
		int max=0;
		
		for(int k=0;k<size-1;k++) {
			char[]sarr = s.toCharArray();
			int[]pi =  new int[sarr.length];
			int j=0;
			for(int i=1;i<sarr.length;i++) {
				while(j>0 && sarr[i]!=sarr[j]) {
					j=pi[j-1];
				}
				if(sarr[i]==sarr[j]) {
					pi[i]=++j;
					max = Math.max(max,pi[i]);
				}
			}
			s = s.substring(1);
		}
		System.out.println(max);
	}
}