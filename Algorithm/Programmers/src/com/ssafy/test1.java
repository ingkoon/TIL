package com.ssafy;


import java.util.Scanner;

class test1{
    static int T;
    static int n;
    static int[] heights;
    static int[] spares;
    static int result;
    public static void main(String args[]) throws Exception{

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            heights = new int[n];
            spares = new int[n];

            result = 0;
            int maxTree = Integer.MIN_VALUE;

            // 나무 높이 초기화
            for (int i = 0; i < n; i++) {
                int tree = sc.nextInt();
                heights[i] = tree;
                maxTree = Math.max(maxTree, tree);
            }

            // 남은 높이 초기화
            for (int i = 0; i < n; i++) {
                spares[i] = maxTree - heights[i];
            }

            boolean flag = false; // 홀수일 경우에는 false, 짝수일 경우에는 true


//           System.out.println(Arrays.toString(spares) + " / " + flag);
            while(true) {
                boolean breakFlag = false;
                boolean growFlag = false;
                for (int i = 0; i < n; i++) {if(spares[i] != 0) breakFlag = true;}


                if(!breakFlag) break;
                for (int i = 0; i < n; i++) {
                    if(spares[i] == 0) continue;
                    if(!flag && spares[i] % 2 == 1) {
                        spares[i]--;
                        growFlag = true;
                        break;
                    }
                    else if(flag && spares[i] % 2 == 0) {
                        spares[i]-= 2;
                        growFlag = true;
                        break;
                    }
                }


                if(!growFlag) {
                    for (int i = 0; i < n; i++) {
                        if( !flag && spares[i] % 2 == 0 && spares[i] >= 4) {
                            spares[i]--;
                            break;
                        }
                        else if( flag && spares[i] % 2 == 1 && spares[i] >= 3) {
                            spares[i]-=2;
                            break;
                        }
                    }
                }


                flag = !flag;
//               System.out.println(Arrays.toString(spares) + " / " + flag);
                result ++;
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }
}
