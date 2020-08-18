package backjun;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());
		
		int[][] dp = new int[41][2];
		dp[0][0]=1; dp[1][1]=1;
		for(int i=2;i<dp.length;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-2][0];
			dp[i][1]=dp[i-1][1]+dp[i-2][1];
		}
		
		String answer="";
		
		for(int i=0;i<cnt;i++) {
			String s = br.readLine();
			int n = Integer.parseInt(s);
			answer+=dp[n][0]+" "+dp[n][1]+"\n";
		}import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<house.length-1;i++) {
			house[i+1][0] +=Math.min(house[i][1],house[i][2]);
			house[i+1][1] +=Math.min(house[i][0],house[i][2]);
			house[i+1][2] +=Math.min(house[i][1],house[i][0]);
		}
		
		int idx = house.length-1;
		int answer = Math.min(Math.min(house[idx][0],house[idx][1]),house[idx][2]);
		System.out.println(answer);
		
	}
}
		
		System.out.println(answer);	
	}
}


