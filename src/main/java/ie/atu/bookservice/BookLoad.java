package ie.atu.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookLoad implements CommandLineRunner {

    private final BookRepo bookRepo;

    @Autowired
    public BookLoad(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(1L, "Light", "Adam Adams", 1972, 20, 16);

        bookRepo.save(book1);
    }
}
