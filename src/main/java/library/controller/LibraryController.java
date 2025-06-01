package library.controller;

import library.model.Book;
import library.service.LibraryService;
import org.springframework.stereotype.Controller;

@Controller
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    public Book getBook(){
        return service.getBook();
    }
}
