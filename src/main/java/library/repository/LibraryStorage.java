package library.repository;

import library.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryStorage {

    public Book getBook(){
        return new Book("New book 1");
    }
}
