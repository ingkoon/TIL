import java.io.*;
import java.util.*;
class Main {
	static List<Container> building;
	static int n;
	
	static PriorityQueue<Integer > white;
	static int[] black;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input);
		
		building = new ArrayList();
		
		// 더 많은 쪽의 개수를 파악하기 위함
		int bCount = 0; 
		int wCount = 0;
		
		for(int i = 0; i< n; i++){ //.컨테이너 초기화
			int size = Integer.parseInt(br.readLine());
			if(size < 0) {
				wCount ++;
				building.add(new Container(size, false));
				continue;
			}
			bCount ++;
			building.add(new Container(size, true));
		}
		
		boolean flag = wCount >= bCount ? false : true;
		// Collections.sort(building, new Comparator<Container>(o1, o2)->{return o1.size - o2.size;}); 정렬을 못쓴게 너무 후회스럽다.
		
		int size = wCount <= bCount ? wCount : bCount;
		System.out.println( size + size + 1);
	}
	
	static class Container{
		int size;
		boolean color;
		public Container(int size, boolean color){
			this.size = size;
			this.color = color;
		}
	}
}