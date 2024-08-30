package ie.atu.bookservice;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book getBookByTitle(String title) {
        return bookRepo.findBookByBookTitle(title);
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public void updateBook(String title, Book book) {
        Optional<Book> existingBookOptional = bookRepo.findByBookTitle(title);

        if(existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            if (book.getBookTitle() != null)
                existingBook.setBookTitle(book.getBookTitle());
            if (book.getBookAuthor() != null)
                existingBook.setBookAuthor(book.getBookAuthor());
            if (book.getBookYear() != 0)
                existingBook.setBookYear(book.getBookYear());
            if (book.getBookAmount() != 0)
                existingBook.setBookAmount(book.getBookAmount());
            if (book.getBookAgeRange() != 0)
                existingBook.setBookAgeRange(book.getBookAgeRange());

            bookRepo.save(existingBook);
        }
    }
}
