import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int [m];
		int[] lis = new int [m+1]; //꽉 차있을 경우를 대비해 +1 해주기

		// 값을 입력받음
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		int size=0;
		int top=0; //가장 윗단 숫자 가져오기
		for(int i=0;i<m;i++) {
			
			// 작을 경우
			if(top<arr[i]) {
				lis[size++]=arr[i];
			}

			// 클 경우
			else if(top>arr[i]) {
				int left=0;
				int right=size-1;
				int mid=0;
				while(left<=right) {
					mid = (left+right)/2;
					if(lis[mid]<arr[i]) {
						left = mid+1;
					}
					else {
						right=mid-1;
					}
				}
				
				// 위치에 맞게 값을 넣어준다
				if(lis[mid]<arr[i]) {
					lis[mid+1]=arr[i];
				}
				else {
					lis[mid]=arr[i];
				}
			}
			//상단 값 초기화
			top=lis[size-1];
		}
		System.out.println(size);
		
	}
}
