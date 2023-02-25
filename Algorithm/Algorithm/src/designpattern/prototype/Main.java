package designpattern.prototype;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.ListAll();

        // 프로토타입 구현체 복사
        User user1 = (User) user.clone();
        User user2 = (User) user.clone();

        List<String> userList1 = user1.getUsersList();
        List<String> userList2 = user2.getUsersList();

        userList1.add("d");
        userList2.add("e");

        System.out.println(Arrays.toString(user.getUsersList().toArray()));
        System.out.println(Arrays.toString(userList1.toArray()));
        System.out.println(Arrays.toString(userList2.toArray()));

    }
}
