package line;

public class Solution1 {
    public static void main(String[] args) {
        int[][] queries = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};

        System.out.println(solution(queries));
    }

    static int[] check;
    public static int solution(int[][] queries) {
        int tmp = 0;
        int result = 0;
        for (int[] query : queries) {
            tmp = Math.max(query[0], tmp);
        }
        check = new int[tmp+1];
        int[][] array = new int[tmp+1][0];
        int[] check = new int[tmp+1];

        for (int i = 0; i < queries.length; i++) {
            int num = queries[i][0];
            int cnt = queries[i][1];
            if(array[num].length == 0){
                int size = init(cnt);
                array[num] = new int[size];
                array[num] = initCopy(cnt, new int[size]);
                check[num] = cnt;
            }
            else if(array[num].length < check[num] + cnt){
                int size = init(check[num] + cnt);
                System.out.println(size);
                array[num] = new int[size];
                result += check[num];
                array[num] = copy(cnt, array[num], size, check[num]);
                check[num] += cnt;

            }
            else{
                array[num] = copy(cnt, array[num], array[num].length, check[num]);
                check[num] += cnt;
            }
        }

        return result;
    }

    private static int[] copy(int newCnt, int[] array, int size, int cnt) {
        int[] arr = new int[size];
        for (int i = 0; i < cnt; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < newCnt; i++) {
            arr[cnt + i] = 1;
        }
        return arr;
    }

    //배열 초기화
    public static int init(int num){
        int tmp = 1;
        while(tmp < num){
            tmp *= 2;
        }
        return tmp;
    }

    //배열에 아무것도 없을 떄 초기화
    public static int[] initCopy(int cnt, int[] array){
        for (int i = 0; i <cnt; i++) {
            array[i] = 1;
        }

        return array;
    }
}
