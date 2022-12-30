import java.util.*;
import java.text.SimpleDateFormat;

public class test {
    public static void main(String[] args) {
        int[][] days = {{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(new Date());
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5));
        int idx = (year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0 ? 0 : 1;

        System.out.println(days[idx][month] + " days for " + year + "-" + month);
    }
}