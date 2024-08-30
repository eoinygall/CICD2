package ie.atu.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    Book findBookByBookTitle(String title);

    Optional<Book> findByBookTitle(String title);
}
