package tobyspring.helloboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

//@RestController
@RequestMapping("/")
@RestController
public class HelloControllerV2{
    /**
     * controller의 역할은 요청에 대한 검증을 수행하는 것이다.
     * 따라서 Objects.requireNonNull()로 감싸서 반환을 수행한다
    */
    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();
        return  helloService.sayHello(Objects.requireNonNull(name));
    }

}
