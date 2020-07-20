import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int[] pi;
	static int answer;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char s[] = br.readLine().toCharArray();
		char p[] = br.readLine().toCharArray();
		String ans = kmp(s,p);
		System.out.println(answer);
		System.out.println(ans);
		
	}

	static public String kmp(char[] s , char[] p){
		getPi(p);
		int j=0;
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<s.length;i++) {
			while(j>0 && s[i]!=p[j]) {
				j=pi[j-1];
			}
			if(s[i]==p[j]) {
				if(j==p.length-1) {
					answer++;
					sb.append(i-j+1).append("\n");
					j=pi[j];
				}
				else j++;
			}
		}
		return sb.toString();
	}

	static public void getPi(char[] p) {
		pi = new int[p.length];
		int j=0;
		for(int i=1;i<pi.length;i++ ) {
			while(j>0 && p[i]!=p[j]) {
				j=pi[j-1];
			}
			if(p[i]==p[j]) {
				pi[i]=++j;
			}
		}
	}
}