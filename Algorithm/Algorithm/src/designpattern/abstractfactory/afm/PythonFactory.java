package designpattern.abstractfactory.afm;

public class PythonFactory implements LanguageFactory{
    @Override
    public Print createPrint() {
        return new PythonPrint();
    }

    @Override
    public Input createInput() {
        return new PythonInput();
    }
}
