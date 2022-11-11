package proxy;

public class RealSubject implements Subject{

    public RealSubject() {
        System.out.println("create RealSubject");
    }

    @Override
    public void testSub() {
        System.out.println("test");
    }
}
