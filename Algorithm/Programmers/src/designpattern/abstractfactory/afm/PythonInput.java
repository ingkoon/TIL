package designpattern.abstractfactory.afm;


public class PythonInput implements Input {
    @Override
    public void input(String text) {
        System.out.println(text);
    }
}
