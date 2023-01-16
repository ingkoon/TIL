package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class User implements Prototype{
    private List<String> usersList;

    public User() {
        usersList = new ArrayList<>();
    }

    public User(List<String> usersList) {
        this.usersList = usersList;
    }

    public List<String> getUsersList() {
        return usersList;
    }

    public void ListAll(){
        usersList.add("a");
        usersList.add("b");
        usersList.add("c");
    }



    @Override
    public Object clone() throws CloneNotSupportedException {
        return new User(new ArrayList<>(this.usersList));
    }
}
