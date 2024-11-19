public class Seat {
    private Passenger passenger;
    private final String seatId;
    private Boolean useBlocked;

    Seat(String seatId, Boolean useBlocked) {
        this.seatId = seatId;
        this.useBlocked = useBlocked;
    }

    public String getSeatId(){
        return this.seatId;
    }

    public Boolean isBlocked(){
        return this.useBlocked;
    }

    public Boolean isEmpty(){
        return this.passenger == null;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }
    public Boolean setPassenger(Passenger passenger) {
        if(this.useBlocked){ return false; }
        this.passenger = passenger;
        return true;
    }
}
