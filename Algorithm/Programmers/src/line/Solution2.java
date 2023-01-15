package line;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int k = 2;
        String[] dic = {"slang", "badword"};
        String chat = "badword ab.cd bad.ord word sl.. bad.word";
        System.out.println(solution(k, dic, chat));
    }
    public static String solution(int k, String[] dic, String chat) {

        String[] c = chat.split(" ");
        System.out.println(Arrays.toString(c));
        StringBuilder answer = new StringBuilder();

        for (String s : c) {
            if(containCheck(dic, s)) {
                for (int i = 0; i < s.length(); i++) {
                    answer.append("#");
                }
            }
            else if(replaceCheck(dic, s, k)){
                for (int i = 0; i < s.length(); i++) {
                    answer.append("#");
                }
            }else{
                answer.append(s);
            }
            answer.append(" ");
        }

        return answer.toString();
    }

    private static boolean replaceCheck(String[] dic, String s, int k) {
        String word = "";

        StringBuilder sb = new StringBuilder();
        String[] tmp = s.split(".");
        for (String s1 : tmp) {
            sb.append(s1);
        }
        String checkWord = sb.toString();

        for (String d : dic) {
            if(d.contains(checkWord)) word = d;
        }

        for (int i = 0; i < s.length(); i++) {

        }
        return true;
    }

    //포함되는지 여부를 확인
    private static boolean containCheck(String[] dic, String s) {
        for (String d : dic) {
            if(d.contains(s))
                return true;
        }
        return false;
    }
}
