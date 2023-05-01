package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    /*
    query String 타입으로 입력을 받아서 출력한다.
    */
    @GetMapping("/hello")
    public String hello(String name){

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
