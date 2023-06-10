package com.targetindia.programs;

import com.targetindia.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class SpringContainerDemo1 {
    public static void main(String[] args) {
        // create a spring container
        // choose between ClassPathXmlApplicationContext or
        // FileSystemXmlApplicationContext or AnnotatioConfigApplicationContext

        try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml")){
            // at this time, the `new ClassPathXmlApplicationContext()` creates a new spring container
            // (capable of containing and managing beans), and loads all the beans defined in the context.xml

            HelloService service = ctx.getBean("khs", HelloService.class);
            log.trace("service is an instanceof {} class", service.getClass().getName());
            log.trace("hello message from the service object is: {}", service.getHelloMessage("Vinod"));


        } // ctx.close() called here automatically
    }
}
