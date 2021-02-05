package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			char[] memory = br.readLine().toCharArray();
			int cnt=memory[0]=='1'?1:0;
			
			for(int j=1;j<memory.length;j++) {
				if(memory[j-1]!=memory[j]) {
					cnt++;
				}
			}
			System.out.println("#"+i+" "+cnt);
	
		}
		
	}

}
