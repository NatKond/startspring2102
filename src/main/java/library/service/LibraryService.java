package library.service;

import library.model.Book;
import library.repository.LibraryStorage;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryStorage libraryStorage;

    public LibraryService(LibraryStorage libraryStorage) {
        this.libraryStorage = libraryStorage;
    }

    public Book getBook(){
        return libraryStorage.getBook();
    }
}
