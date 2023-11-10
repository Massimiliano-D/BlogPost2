package massimiliano.BlogPost.Payloads;

import jakarta.validation.constraints.NotEmpty;

public record PostDTO(String categoria,
                      @NotEmpty(message = "Campo del titolo Obbligatorio!")
                      String titolo,
                      String cover,
                      @NotEmpty(message = "Campo del contenuto Obbligatorio!")
                      String contenuto,
                      int tempoDiLettura) {
}