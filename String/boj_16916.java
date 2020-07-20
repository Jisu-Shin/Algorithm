import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int[] pi;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		
		System.out.println(kmp(s,p));
	}

	static public int kmp(char[] s , char[] p){
		getPi(p);
		int j=0;
		for(int i=0;i<s.length;i++) {
			while(j>0 && s[i]!=p[j]) {
				j=pi[j-1];
			}
			if(s[i]==p[j]) {
				if(j==p.length-1) {
					return 1;
				}
				else j++;
			}
		}
		return 0;
	}

	static public void getPi(char[] p) {
		pi = new int[p.length];
		int j=0;
		for(int i=1;i<p.length;i++) {
			while(j>0 && p[i]!=p[j]) {
				j=pi[j-1];
			}
			if(p[i]==p[j]) pi[i]=++j;
			
		}
	}
}