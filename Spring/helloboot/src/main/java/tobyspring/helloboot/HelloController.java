package tobyspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

//@RestController
@RequestMapping("/")
@RestController
public class HelloController implements ApplicationContextAware {
    private final HelloService helloService;
    private ApplicationContext applicationContext;
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    /*
    query String 타입으로 입력을 받아서 출력한다.
    */
    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }
}
