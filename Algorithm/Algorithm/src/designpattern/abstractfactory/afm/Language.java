package designpattern.abstractfactory.afm;

public class Language {

    private Input input;
    private Print print;

    public Language(Input input, Print print){
        this.input = input;
        this.print = print;
    }

    public Input getInput() {
        return input;
    }

    public Print getPrint() {
        return print;
    }
}
