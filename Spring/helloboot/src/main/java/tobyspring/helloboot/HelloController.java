package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /*
    query String 타입으로 입력을 받아서 출력한다.
    */
    @GetMapping("/hello")
    public String hello(String name){
        return "Hello" + name;
    }
}
