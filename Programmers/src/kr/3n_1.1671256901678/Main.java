import java.io.*;
import java.util.*;
class Main {
	
	static int[] arr;
	static int SIZE = 20000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringTokenizer st = new StringTokenizer(input);
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		arr = new int[SIZE];
		for(int i = a; i<=b; i++){
			int cycle = calc(i);
			max = Math.max(max, cycle);
		}
		System.out.println(max);
	}
	static int calc(int n){
		int cnt = 1;
		while(n != 1){
			cnt++;
			if(n < SIZE && arr[n] != 0){ // 연산값이 존재하면 값 이동
				n = arr[n];
				continue;
			}
			// 연산값이 부재할경우 
			if(n % 2== 0) {	
				arr[n] = n/2;
				n /=2;
				continue;
			}
			arr[n] = n * 3 + 1;
			n = n * 3 + 1;
		}
		return cnt;
	}
}