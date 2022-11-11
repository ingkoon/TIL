package Facade;

public class Facade {

    public void  createFacade(){
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Test3 test3 = new Test3();

        test1.testPrint1();
        test2.testPrint2();
        test3.testPrint3();
    }

}
