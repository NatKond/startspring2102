package library.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

//@Service
//@Lazy
//@Scope("prototype")
@Component("serviceOne")
public class LibraryServiceTwo {

    @PostConstruct
    public void init(){
        System.out.println("After create");
    }
}
