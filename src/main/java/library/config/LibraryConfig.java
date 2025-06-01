package library.config;

import library.service.LibraryService;
import library.service.LibraryServiceTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration // указывает Spring что в этом классе прописываются настройки банов
@ComponentScan(basePackages = {"library"})
public class LibraryConfig {

    @Bean("serviceTwo") // данный объект передан спрингу как бин
    public LibraryServiceTwo libraryServiceTwo(){
        return new LibraryServiceTwo();
    }
}
