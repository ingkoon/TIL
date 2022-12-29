package kr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution5_2 {
    static int n;
    static int[] building;
    static List buildingV2;
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        building = new int[n];
        buildingV2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            building[i] = tmp;
            buildingV2.add(tmp);
        }

        Collections.sort(buildingV2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        });

//        System.out.println(Arrays.toString(buildingV2.toArray()));
        building = buildingV2.stream().mapToInt(i-> (int) i).toArray();

        System.out.println(Arrays.toString(building));
        boolean flag = building[0] > 0; // 양수일 경우 true, 음수일 경우 false

        for (int i = 1; i < n; i++) {
            if((flag && building[i] < 0) || (!flag && building[i] > 0)) {
                result ++;
                flag = !flag;
            }
        }
        System.out.println(result);
    }
}
/*
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
 */