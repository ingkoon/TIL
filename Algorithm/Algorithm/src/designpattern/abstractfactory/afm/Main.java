package designpattern.abstractfactory.afm;

public class Main {
    public static void main(String[] args) {
        LanguageFactory cf = new CFactory();
        Language c = new Language(cf.createInput(), cf.createPrint());

        c.getPrint().print();

        LanguageFactory pf = new PythonFactory();
        Language p = new Language(pf.createInput(), pf.createPrint());
    }
}
