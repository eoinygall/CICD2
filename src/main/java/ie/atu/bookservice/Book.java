package ie.atu.bookservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Author Cannot be blank")
    private String bookAuthor;

    @NotBlank(message = "Title Cannot be blank")
    private String bookTitle;

    @Min(value = 0, message = "Amount cannot be less than 0")
    private int bookAmount;

    @NotNull(message = "year cannot be blank")
    private int bookYear;

    @NotNull(message = "Age Range must be be entered")
    private int bookAgeRange;
}
