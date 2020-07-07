package backjun;

import java.io.*;
public class Main2 { 
	public static void main(String[] args) throws IOException { 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int charge = Integer.parseInt(br.readLine());
		
		//5원 아니면 2원
		int coin_5=charge/5;
		int chk=charge%5%2;
		int coin_2;

		if(chk!=0) {
			--coin_5;
			coin_2=(charge-coin_5*5)/2;
		}
		else {
			coin_2=charge%5/2;
		}

		if(coin_5<0) System.out.println(-1);
		else System.out.println(coin_5+coin_2);

	}
}

