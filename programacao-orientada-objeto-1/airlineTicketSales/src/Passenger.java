import java.time.LocalDate;

public class Passenger {
    private String name;
    private String email;
    private String address;
    private LocalDate birthDate;
    private Boolean comorbidities;

    Passenger(String name, String email, String address, LocalDate birthDate, Boolean Comorbidities) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.comorbidities = Comorbidities;
    }
}
