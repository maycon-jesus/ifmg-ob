import java.util.ArrayList;

public class Flight {
    public Seat[][] seats = new Seat[12][4];

    private String intToAlphabet(int num){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(num, num+1);
    }

    Flight() {

//        Define os ids dos assentos. Ex. 1A, 1B, 2A.
        for (int i = 0; i < seats.length; i++) {
            Seat[] line = seats[i];
            for (int j = 0; j < line.length; j++) {
                line[j] = new Seat(String.valueOf(i+1)+ intToAlphabet(j), j==1);
            }
        }
    }

    public ArrayList<Seat> getSeatsByBusyStatus(Boolean busy) {
        ArrayList<Seat> nList = new ArrayList<>();
        for (Seat[] line : seats) {
            for (Seat seat : line) {
                if(busy && !seat.isEmpty()){
                    nList.add(seat);
                }

                if(!busy && seat.isEmpty()){
                    nList.add(seat);
                }
            }
        }

        return nList;
    }
}
