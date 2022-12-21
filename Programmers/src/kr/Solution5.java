package kr;

import java.io.*;
import java.util.*;
class Solution5 {
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
		
		Collections.sort(building, new Comparator<Container>() {
			@Override
			public int compare(Container o1, Container o2) {
				return Math.abs(o2.size) - Math.abs(o1.size);
			}
		});

		System.out.println(Arrays.toString(building.toArray()));

		for (Container container : building) {
			
		}
	}
	
	static class Container{
		int size;
		boolean color;
		public Container(int size, boolean color){
			this.size = size;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Container{" +
					"size=" + size +
					'}';
		}
	}
}

/*
* 하나씩 쌓아 올려나간다. 음수일 경우 양수일 경우 번갈아 가면서 쌓아올려나가야 한다.
*
*
11
-17
10
-15
15
12
9
-5
-2
14
-12
12
* */