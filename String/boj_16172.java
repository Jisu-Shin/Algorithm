import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] pi;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		StringBuilder sb= new StringBuilder();
		for(char si : s) {
			if(!Character.isDigit(si)) sb.append(si);
		}
		s = sb.toString().toCharArray();
		char[] p = br.readLine().toCharArray();
		System.out.println(KMP(p,s));
	}
	
	public static int KMP(char[]p,char[]s) {
		int j=0;
		int[]pi = getPi(p);
		for(int i=0;i<s.length;i++) {
			while(j>0 && p[j]!=s[i]) {
				j=pi[j-1];
			}
			if(p[j]==s[i]) {
				if(j==p.length-1) return 1;
				else j++;
			}
		}
		return 0;
	}
	
	public static int[] getPi(char[] p) {
		int[]pi = new int[p.length];
		int j=0;
		for(int i=1;i<p.length;i++) {
			while(j>0 && p[j]!=p[i]){
				j=pi[j-1];
			}
			if(p[j]==p[i]) pi[i]=++j;
		}
		return pi;
	}
}
