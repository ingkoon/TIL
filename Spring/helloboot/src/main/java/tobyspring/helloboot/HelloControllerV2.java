package tobyspring.helloboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/")
@RestController
public class HelloControllerV2{
    /*
    query String 타입으로 입력을 받아서 출력한다.
    */
    public String hello(String name){
      return "Hello " + name;
    }

}
