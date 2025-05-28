package library;

import library.config.LibraryConfig;
import library.controller.LibraryController;
import library.model.Book;
import library.repository.LibraryStorage;
import library.service.LibraryService;
import library.service.LibraryServiceTwo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@ComponentScan(basePackages = {"library"})
public class LibraryApp {

    public static void main(String[] args) {
//        LibraryStorage storage = new LibraryStorage();
//        LibraryService service = new LibraryService(storage);

        ApplicationContext context =
                //new ClassPathXmlApplicationContext("bean.xml");
                new AnnotationConfigApplicationContext(LibraryApp.class);
                // new JavaC

        LibraryService service = context.getBean(LibraryService.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        LibraryConfig libraryConfig = context.getBean(LibraryConfig.class);
        Book book = service.getBook();
        System.out.println(book);

        // LibraryController controller = context.getBean(LibraryController.class);
        // controller.start();
    }
}
