import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution {
 
    private static final int EXPONENT1 = 2;
    private static final int EXPONENT2 = 3;
    private static final int EXPONENT3 = 5;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            String B = br.readLine();
            String S = br.readLine();
 
            sb.append('#').append(testCase).append(' ').append(getCount(B, S)).append('\n');
        }
 
        bw.write(sb.toString());
        bw.flush();
 
        br.close();
        bw.close();
    }
 
    // Rabin–Karp algorithm
    private static int getCount(String string, String pattern) {
        int count = 0;
 
        int stringLength = string.length();
        int patternLength = pattern.length();
 
        int stringHash1 = 0;
        int patternHash1 = 0;
 
        int stringHash2 = 0;
        int patternHash2 = 0;
 
        int stringHash3 = 0;
        int patternHash3 = 0;
 
        int power1 = 1;
        int power2 = 1;
        int power3 = 1;
 
        for (int i = 0; i <= stringLength - patternLength; i++) {
            if (i == 0) {
                for (int j = 0; j < patternLength; j++) {
                    stringHash1 += hash(string.charAt(patternLength - 1 - j), power1);
                    patternHash1 += hash(pattern.charAt(patternLength - 1 - j), power1);
 
                    stringHash2 += hash(string.charAt(patternLength - 1 - j), power2);
                    patternHash2 += hash(pattern.charAt(patternLength - 1 - j), power2);
 
                    stringHash3 += hash(string.charAt(patternLength - 1 - j), power3);
                    patternHash3 += hash(pattern.charAt(patternLength - 1 - j), power3);
 
                    if (j < patternLength - 1) {
                        power1 *= EXPONENT1;
                        power2 *= EXPONENT2;
                        power3 *= EXPONENT3;
                    }
                }
            } else {
                stringHash1 = EXPONENT1 * (stringHash1 - hash(string.charAt(i - 1), power1))
                        + string.charAt(patternLength - 1 + i);
 
                stringHash2 = EXPONENT2 * (stringHash2 - hash(string.charAt(i - 1), power2))
                        + string.charAt(patternLength - 1 + i);
 
                stringHash3 = EXPONENT3 * (stringHash3 - hash(string.charAt(i - 1), power3))
                        + string.charAt(patternLength - 1 + i);
            }
 
            if (stringHash1 == patternHash1 && stringHash2 == patternHash2
                    && stringHash3 == patternHash3) {
                count++;
            }
        }
 
        return count;
    }
 
    private static int hash(int value, int power) {
        return value * power;
    }
}