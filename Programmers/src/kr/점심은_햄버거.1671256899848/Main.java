import java.io.*;
import java.util.*;
class Main {
	static List<food> foods;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		StringTokenizer e = new StringTokenizer(br.readLine());
		StringTokenizer t = new StringTokenizer(br.readLine());
		foods = new ArrayList();
		for(int i = 0; i< n; i++){
			int eat = Integer.parseInt(e.nextToken());
			int toast = Integer.parseInt(t.nextToken());
			foods.add(new food(eat, toast));
		}
		Collections.sort(foods, new Comparator<food>((o1, o2) ->{
			@override
			int compareTo(food o1, food o2){
				return o1.eat - o2.eat;
				}
			);
		}) 
	}
	
	static class food {
		int eating;
		int toasting;
		public food(int eating, int toasting){
			this.eating = eating;
			this.toasting = toasting;
		}
	}
	
}
/*
햄버거를 데우는 시간부터 모든사람이 식사를 끝내는 시간
3 3 3 3 
	2 2 2 2
	    1 1 => 5
2 2 2 2 
    2 2 2 2 
		    2 2 2 2 => 8
*/
