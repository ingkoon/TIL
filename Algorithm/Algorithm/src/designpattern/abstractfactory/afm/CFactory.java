package designpattern.abstractfactory.afm;

public class CFactory implements LanguageFactory {
    @Override
    public Print createPrint() {
        return new CPrint();
    }
    @Override
    public Input createInput() {
        return new CInput();
    }
}
