package kr;

import java.io.*;
import java.util.*;
class Solution1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringTokenizer st = new StringTokenizer(input); // 입력 정리
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int result = 0; // 초기 결과값은 0
		for(int i = 0; i < n; i++){ // m번째에 도달할 때마다 하나의 피자가 추가되며 이에대한 쿠폰이 발급
			 result += 1; // 기본적으로 한판의 피자가 추가된다.
				if(result % m == 0){ // m번째에 도달할경우 1판 추가
					result ++;
				}
		}
		System.out.println(result); // 결과값 출력
	}
}