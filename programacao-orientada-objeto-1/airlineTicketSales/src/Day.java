import java.time.LocalDate;

public class Day {
    private LocalDate date;
    private Flight flight = new Flight();

    Day(LocalDate date) {
        this.date = date;
    }
}
