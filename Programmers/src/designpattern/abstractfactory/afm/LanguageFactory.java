package designpattern.abstractfactory.afm;

public interface LanguageFactory {
    public Print createPrint();
    public Input createInput();
}
