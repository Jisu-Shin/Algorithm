package backjun;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		char[] number = s.toCharArray();
		int[] count = new int[10];
		for(char n : number) {
			count[n-'0']++;
		}
		
		count[6]=(int)Math.ceil((count[6]+count[9])/2.0); // Math.ceil 천장함수 쓰자 !
		count[9]=0;
		

		int max=Integer.MIN_VALUE;
		for(int c:count) {
			max=Math.max(c, max);
		}
		
		System.out.println(max);
	}
}


