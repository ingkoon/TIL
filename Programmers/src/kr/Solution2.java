package kr;

import java.io.*;
import java.util.*;
class Solution2 {
	static List<food> foods;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input); // 햄버거 개수 입력

		StringTokenizer e = new StringTokenizer(br.readLine()); // 햄버거를 먹는 시간
		StringTokenizer t = new StringTokenizer(br.readLine()); // 햄버거를 익히는 시간

		foods = new ArrayList(); // 행버거 익히는/먹는시간을 담는 list foods

		for(int i = 0; i< n; i++){
			int eat = Integer.parseInt(e.nextToken());
			int toast = Integer.parseInt(t.nextToken());
			foods.add(new food(eat, toast));
		}

		Collections.sort(foods, (o1, o2) -> { // 익히는시간과 먹는시간의 차가 작을 수록 앞에 오도록 한다.
			int one = o1.toasting - o1.eating;
			int two = o2.toasting - o2.eating;
			return one - two;
		});
		
		int eat = 0; // 최종적으로 먹는 시간이 가장 큰 값이 답이다.
		int toast = 0;
		for (food food : foods) {
			toast += food.toasting;	// 현재 햄버거를 익히는 시간
			eat = Math.max(eat, toast + food.eating); //  현재 햄버거를 다 익히고 먹는 시간을 비교하여 정답을 출력한다.
		}

		System.out.println(eat);
	}
	
	static class food {
		int eating; // 먹는 시간
		int toasting; // 전자레인지에 돌리는 시간
		public food(int eating, int toasting){
			this.eating = eating;
			this.toasting = toasting;
		}
	}
}


/*
3
3 2 1
1 2 1
햄버거를 데우는 시간부터 모든사람이 식사를 끝내는 시간
3 3 3 3 
	2 2 2 2
	    1 1 => 5
2 2 2 2 
    2 2 2 2 
		    2 2 2 2 => 8

3
2 2 2
2 2 2
*/
