package kodlamaio.hrms.core.utilities.adapters.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MernisPerson {
    private String firstName;
    private String lastName;
    private String IdentityNumber;
    private LocalDate birthDate;
}