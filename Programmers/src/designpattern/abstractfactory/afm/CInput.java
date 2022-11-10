package designpattern.abstractfactory.afm;


public class CInput implements Input {
    @Override
    public void input(String text) {
        System.out.println(text);
    }
}
