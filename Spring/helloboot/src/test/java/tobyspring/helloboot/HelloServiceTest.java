package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void SimpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService();
        String res = helloService.sayHello("Test");
        Assertions.assertThat(res).isEqualTo("Hello Test");
    }
}
/*
고립된 테스트가 가능하다.

 */
