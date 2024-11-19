import java.time.LocalDate;

public class Main {
    private static Day[] allDays = new Day[31];

    public static void main(String[] args) {
        for (int i = 0; i < 31; i++) {
            allDays[i] = new Day(LocalDate.now().plusDays(i));
        }



        Flight flight = new Flight();
        System.out.println(flight.seats[0][0].isBlocked());
        System.out.println(flight.seats[5][1].isBlocked());
        System.out.println(flight.seats[0][2].isBlocked());
        System.out.println(flight.seats[0][3].isBlocked());
    }
}

// https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401