package proxy;

public class Main {
    public static void main(String[] args) {
        Subject proxy = new ProxySubject();
        proxy.testSub();
    }
}
