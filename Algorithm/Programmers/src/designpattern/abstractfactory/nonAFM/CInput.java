package designpattern.abstractfactory.nonAFM;

public class CInput implements Input{
    @Override
    public void input(String text) {
        System.out.println(text);
    }
}
