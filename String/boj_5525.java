package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		StringBuilder pn = new StringBuilder();
		pn.append("I");
		while(p-->0) {
			pn.append("OI");
		}
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int answer=kmp(s.toCharArray(),pn.toString().toCharArray());
		System.out.println(answer);
	}

	static public int kmp(char[] s , char[] p){
		int[] pi = getPi(p);
		int answer=0;
		int j=0;
		for(int i=0;i<s.length;i++) {
			while(j>0 &&s[i]!=p[j]) {
				j=pi[j-1];
			}
			if(s[i]==p[j]) {
				if(j==p.length-1) {
					answer++;
					j=pi[j];
				}
				else {
					j++;
				}
			}
		}
		return answer;
	}

	static public int[] getPi(char[] p) {
		int[] pi = new int[p.length];
		int j=0;
		for(int i=1;i<pi.length;i++) {
			while(j>0 && p[i]!=p[j]) {
				j=pi[j-1];
			}
			if(p[i]==p[j]) pi[i] = ++j;
		}
		return pi;
	}
}


