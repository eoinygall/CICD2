package ie.atu.bookservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookControl {

    private final BookService bookService;

    @Autowired
    public BookControl(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBook/{title}")
    Book getBook(@PathVariable String title) {

        return bookService.getBookByTitle(title);
    }

    @PostMapping("/saveBook")
    public String addBookToRepo(@RequestBody Book book) {
        if (book == null) {
            return "No book found";
        }
        bookService.addBook(book);
        return "Added book " + book.getBookTitle();
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookFromRepo(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted";
    }

    @PutMapping("/updateBook/{title}")
    String editBookInRepo(@PathVariable String title, @RequestBody Book book){
        bookService.updateBook(title, book);
        return "Book updated";
    }

}
