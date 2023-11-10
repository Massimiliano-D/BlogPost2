package massimiliano.BlogPost.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UtenteDTO(@NotEmpty(message = "Campo del nome Obbligatorio!") String name,
                        @NotEmpty(message = "Campo del cognome Obbligatorio!") String surname,
                        @NotEmpty(message = "Campo del nome Obbligatorio!")
                        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida") String email,
                        @NotNull(message = "Campo della data di nascita Obbligatorio!") LocalDate dataDiNascita,
                        String avatar) {
}
