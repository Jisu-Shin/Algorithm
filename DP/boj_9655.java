package backjun;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());
		
		if(cnt%2==1) {
			System.out.println("SK");
		}
		else {
			System.out.println("CY");
		}
		
	}
}


