package proxy;

public class ProxySubject implements Subject{

    private Subject subject;

    @Override
    public void testSub() {
        if(subject==null){
            subject = new RealSubject();
        }
    }
}
