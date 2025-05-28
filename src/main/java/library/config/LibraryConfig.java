package library.config;

import library.service.LibraryService;
import library.service.LibraryServiceTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    @Bean
    public LibraryServiceTwo libraryServiceTwo(){
        return new LibraryServiceTwo();
    }
}
