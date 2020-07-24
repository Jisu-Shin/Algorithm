import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int[] alpa = new int[26];
		while(m-->0) {
			String s = br.readLine();
			for(int i=0;i<s.length();i++) {
				alpa[s.charAt(i)-'A'] +=Math.pow(10,s.length()-1-i);
			}
		}
		Arrays.sort(alpa);
		int size = alpa.length;
		int num=9;
		int answer=0;
		while(size-->0&&alpa[size]!=0) {
			answer+=alpa[size]*(num--);
		}
		System.out.println(answer);
	}
}