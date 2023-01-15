package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class test2 {
    static int T;
    static int ms, ma; //  초기 예치금, 월별 불입금액
    static int n, l;
    static int[][] term;
    static int[][] benefits;

    public static void main(String args[]) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++){
            /* 초기화 단계*/
            StringTokenizer st;
            st = new StringTokenizer(bf.readLine());
            ms = Integer.parseInt(st.nextToken());
            ma = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken()) + 1;

            term = new int[n][l];
            benefits = new int[n][l];

            int tmp = ms + ma * (l-1);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < l; j++) {
                    term[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            /* 초기화 끝 */

            // 다음 개월 차가 고점인지 저점인지 파악 양수일 경우는 다음달이 저점, 음수일 경우는 다음달이 고정
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < l-1; j++) {
                    benefits[i][j] = term[i][j] - term[i][j + 1];
                }
            }


            int[] stock = new int[n];

            for (int i = 0; i < l; i++) {

                // 현재 주식 처분
                for (int j = 0; j < n; j++) {
                    ms += stock[j] * term[j][i];
                    stock[j] = 0;
                }

                // 최댓값
                int maxLoc = 0;

                List<Integer> locVal = new ArrayList<>();
                int[] ben = new int[n];
                for (int j = 0; j < n; j++) {
                    if(benefits[j][i] < 0) {
                        maxLoc = Math.min(maxLoc, benefits[j][i]); // 음수여야 흑자이므로
                        locVal.add(j);
                        ben[j] = benefits[j][i];
                    }
                }


                if(i == 0) {
                    for(int loc : locVal) {
                        if(loc > ms) continue; // 현재 원금보다 적을 경우 패스
                        int val = ms / term[loc][i]; // 원금/한주당 금액 몫을 구한다.
                        stock[loc] += val;    // 현재 주식의
                        ms -= val * term[loc][i];                     // 원금에서 값 차감
                    }
                }
                // 다음달에 팔아도 이익이 안날 종목밖에 없다면
                // 현재 갖고있는 주식 처분 후 불입 금액 추가
                else if(maxLoc == 0) {
                    ms += ma;
                }
                else {
                    // 블입 금액 추가
                    ms += ma;
                    // 주식 처분

                    int cnt = 0;
                    while(cnt < n) {
                        cnt++;
                        int maxVal = Integer.MAX_VALUE;
                        boolean flag = false;
                        int loc = 0;

                        for (int j = 0; j < ben.length; j++) {
                            if(ben[j] < maxVal) {
                                loc = j;
                                maxVal = ben[j];
                                flag = true;
                            }
                            if(ben[j] == maxVal) {
                                loc = term[j][i] < term[loc][i] ? j : loc;
                                maxVal = term[j][i] < term[loc][i] ? ben[j] : ben[loc];
                                flag = true;
                            }
                        }
                        ben[loc] = 0;
                        if(!flag) break;
                        if(loc > ms) continue; // 현재 원금보다 적을 경우 패스
                        int val = ms / term[loc][i]; // 원금/한주당 금액 몫을 구한다.
                        if(val == 0) continue; // 현재 원금보다 적을 경우 패스
                        stock[loc] += val;    // 현재 주식의
                        ms -= val * term[loc][i];                     // 원금에서 값 차감
                    }
                }
            }

            int result = ms - tmp;
            System.out.printf("#%d %d\n", t, result);
        }
    }
}