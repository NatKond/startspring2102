package library.controller;

import library.config.LibraryConfig;
import library.model.Book;
import library.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    public void start(){
        ApplicationContext context =
                //new ClassPathXmlApplicationContext("bean.xml");
                new AnnotationConfigApplicationContext(LibraryConfig.class);

        LibraryService service = context.getBean(LibraryService.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Book book = service.getBook();
        System.out.println(book);
    }
}
